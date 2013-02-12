package fr.isima.stackoverlow

/**
 * Controlleur des pages des questions
 * @author Julien
 */
class QuestionController {
	
	/**
	 * Afficher la liste des questions
	 * @param page Numéro de page (optionnel)
	 * @param pagesize Nombre de questions par page (optionnel)
	 * @param sort Type de tri
	 * @return Page des questions <br/>
	 *         Page d'erreur si inexistante
	 * @author Julien
	 */
	def all() {
		// Paramètres
		// - numéro de page
		int defaultPage = 1
		int page = defaultPage
		try {
			page = params.page.toInteger()
		} catch (NumberFormatException e) {
			return render(view: "/question/erreur", model: [error: "Numéro de page incorrect."])
		} catch (NullPointerException e) {}
		// - nombre de questions par page
		int defaultPagesize = 15
		int pagesize = defaultPagesize
		try {
			if (params.pagesize != null)
				pagesize = params.pagesize.toInteger()
			else
				pagesize = session.question_pagesize
		} catch (NumberFormatException e) {
			return render(view: "/question/erreur", model: [error: "Nombre de questions par pages incorrect."])
		} catch (NullPointerException e) {}
		// catch (GroovyCastException e) {} TODO: bug
		if (! [15, 30, 50].contains(pagesize))
			pagesize = defaultPagesize
		session.question_pagesize = pagesize
		// - tri
		Sort defaultSort = Sort.NEWEST
		Sort sort = defaultSort
		if (params.sort != null)
			Sort.fromString(params.sort)
		else if (session.question_sort != null)
			sort = session.question_sort
		if (! [Sort.NEWEST, Sort.VOTES].contains(sort))
			sort = defaultSort
		session.question_sort = sort
		
		// Liste des questions
		int offset = pagesize*(page-1)
		def listQuestions = new QuestionService().get(offset, pagesize, sort)
		if (listQuestions.isEmpty())
			return render(view: "/question/erreur", model: [error: "Aucune question trouvée."])
		
		// Liste des pages
		int totalPages = Math.ceil(Question.count / pagesize)
		def listPages = new Application().getListPages(page, totalPages)
		
		return render(view: "/question/all", model: [listQuestions: listQuestions, sort: sort, currentPage: page, listPages: listPages, pagesize: pagesize])
	}
	
	
	/**
	 * Afficher une question
	 * @param id Identifiant de la question
	 * @param sort Type de tri
	 * @return Page de la question <br/>
	 *         Page d'erreur si inexistante
	 * @author Julien
	 */
    def show() {
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/erreur", model: [error: "Question inexistante."])
		
		// Paramètres
		// - tri
		Sort defaultSort = Sort.OLDEST
		Sort sort = Sort.fromString(params.sort)
		if (! [Sort.OLDEST, Sort.VOTES].contains(sort))
			sort = defaultSort
		question.responses = new ResponseService().get(question, sort)
		
		// Trier les commentaires
		CommentaireService cService = new CommentaireService()
		question.commentaires = cService.get(question)
		for (Response response : question.responses)
			response.commentaires = cService.get(response)
		
		return render(view: "/question/show", model: [question: question, sort: sort])
	}
	
	
	/**
	 * Créer une question
	 * @return Page du formulaire <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def create() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		return render(view: "/question/create")
	}
	
	
	/**
	 * Valider la création d'une question
	 * @param title Titre
	 * @param content Contenu
	 * @param strListTags Liste des noms des tags
	 * @return Page de la question <br/>
	 *         Page du formulaire si erreur <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def create_submit() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Vérifier le formulaire
		if (params.title == null  ||  params.content == null  ||  params.strListTags == null)
			return render(view: "/question/erreur", model: [locality: "askquestion", error: "Passage par le formulaire obligatoire."])
		
		try {
			// Créer
			Question question = new Question(title: params.title, content: params.content, date: new Date())
			question.author = UserController.getUser()
			TagService tService = new TagService()
			for (String name : params.strListTags.split(" +"))
				if (! name.isEmpty()) {
					Tag tag = tService.getOrCreate(name)
					question.addToTags(tag)
				}
			// Sauvegarder
			QuestionService qService = new QuestionService()
			qService.create(question)
			// Afficher
			return redirect(url: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/question/erreur", model: [locality: "askquestion", error: e.getMessage()])
		}
	}
	
	
	/**
	 * Editer une question
	 * @param id Identifiant de la question
	 * @return Page du formulaire <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def edit() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/erreur", model: [error: "Question inexistante."])
		
		// Droits
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), question))
			return render(view: "/question/erreur", model: [error: "Vous devez être l'author ou un administrateur pour pouvoir éditer la question."])
		
		// temporaire
		String strListTags = ""
		question.tags.each { tag ->
			strListTags += tag.name + " "
		}
		
		return render(view: "/question/edit", model: [question: question, strListTags: strListTags])
	}
	
	
	/**
	 * Valider l'édition d'une question
	 * @param id Identifiant de la question
	 * @param title Titre
	 * @param content Contenu
	 * @param strListTags Liste des noms des tags
	 * @return Page de la question <br/>
	 *         Page du formulaire si erreur
	 * @author Julien
	 */
	def edit_submit() {
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/erreur", model: [error: "Question inexistante."])
		
		// Droits
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), question))
			return render(view: "/question/erreur", model: [error: "Vous devez être l'author ou un administrateur pour pouvoir éditer la question."])
		
		// Vérifier le formulaire
		if (params.title == null  ||  params.content == null  ||  params.strListTags == null)
			return render(view: "/question/erreur", model: [error: "Passage par le formulaire obligatoire."])
		
		try {
			// Modifier
			question.title = params.title
			question.content = params.content
			question.tags = []
			TagService tService = new TagService()
			for (String name : params.strListTags.split(" +"))
				if (! name.isEmpty()) {
					Tag tag = tService.getOrCreate(name)
					question.addToTags(tag)
				}
			// Sauvegarder
			QuestionService qService = new QuestionService()
			qService.update(question)
			// Afficher
			return redirect(url: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/question/erreur", model: [error: e.getMessage()])
		}
	}
	
	
	/**
	 * Supprimer une question
	 * @param id Identifiant de la question
	 * @return Page des questions <br/>
	 *         Page de la question si erreur <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def delete() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/erreur", model: [error: "Question inexistante."])
		
		// Droits
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), question))
			return render(view: "/question/erreur", model: [error: "Vous devez être l'author ou un administrateur pour pouvoir supprimer la question."])
		
		try {
			// Supprimer
			QuestionService qService = new QuestionService()
			qService.delete(question)
		} catch (ServiceException e) {
		}
		
		return redirect(url: "/question")
	}
	
}
