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
	 * @return Page des questions <br/>
	 *         Page d'erreur si inexistante
	 * @author Julien
	 */
	def all() {
		// DEBUG

		
		// Paramètres
		// - numéro de page
		int page = 1
		if (params.page != null)
			page = params.page.toInteger()
		// - nombre de questions par page
		int pagesize = 15
		if (params.pagesize != null) {
			if ([15, 30, 50].contains(params.pagesize.toInteger())) {
				pagesize = params.pagesize.toInteger()
				session.question_pagesize = pagesize
			}
		} else if (session.question_pagesize != null)
			pagesize = session.question_pagesize
		// - tri
		// TODO
		
		// Liste des questions
		int offset = pagesize*(page-1)
		int max = pagesize
		def listQuestions = new QuestionService().getDesc(offset, max)
		if (listQuestions.isEmpty())
			return render(view: "/question/nonexistent")
		
		// Liste des pages
		int totalPages = Math.ceil(Question.count / pagesize)
		def listPages = new Application().getListPages(page, totalPages)
		
		return render(view: "/question/all", model: [listQuestions: listQuestions, currentPage: page, listPages: listPages, pagesize: pagesize])
	}
	
	
	/**
	 * Afficher une question
	 * @param id Identifiant de la question
	 * @return Page de la question <br/>
	 *         Page d'erreur si inexistante
	 * @author Julien
	 */
    def show() {
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/nonexistent")
		else
			return render(view: "/question/show", model: [question: question])
	}
	
	
	/**
	 * Valider la création d'une réponse
	 * @param id Identifiant de la question
	 * @param response-content Contenu de la réponse
	 * @return Page de la question
	 * @author Julien
	 */
	def answer_submit() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null) {
			return render(view: "/question/nonexistent")
		} else if (! question.display)
			return render(view: "/question/moderationDeleted")
		
		// Vérifier le formulaire
		if (params["response-content"] == null  ||  params["response-content"] == "")
			return render(view: "/question/show", model: [question: question, listErreurs: ["body is missing"]])
		
		try {
			// Créer la réponse
			Response response = new Response(content: params["response-content"], date: new Date())
			response.author = UserController.getUser()
			response.question = question
			// Sauvegarder
			ResponseService rService = new ResponseService()
			rService.create(response)
			// Affichage
			redirect(url: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/question/show", model: [question: question, listErreurs: [e.getMessage()]])
		}
	}
	
	
	/**
	 * Créer une question
	 * @return Page du formulaire <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def ask() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		return render(view: "/question/ask")
	}
	
	
	/**
	 * Valider la création d'une question
	 * @param title Titre
	 * @param post-text Contenu
	 * @param strListTags Liste des noms des tags
	 * @return Page de la question <br/>
	 *         Page du formulaire si erreur <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def ask_submit() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Vérifier le formulaire
		def listErreurs = []
		// - title
		if (params.title == null  ||  params.title == "")
			listErreurs.add("title is missing")
		// - content
		if (params["post-text"] == null  ||  params["post-text"] == "")
			listErreurs.add("body is missing")
		// - tags
		if (params.strListTags == null  ||  params.strListTags == "")
			listErreurs.add("you need at least one valid tag")
		if (! listErreurs.isEmpty())
			return render(view: "/question/ask", model: [listErreurs: listErreurs])
		
		try {
			// Créer la question
			Question question = new Question(title: params.title, content: params["post-text"], date: new Date())
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
			// Affichage
			redirect(url: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/question/ask", model: [listErreurs: [e.getMessage()]])
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
		// Utilisateur
		// - connecté
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/nonexistent")
		
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
	 * @param post-text Contenu
	 * @param strListTags Liste des noms des tags
	 * @return Page de la question <br/>
	 *         Page du formulaire si erreur
	 * @author Julien
	 */
	def edit_submit() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/nonexistent")
		
		// Vérifier le formulaire
		def listErreurs = []
		// - title
		if (params.title == null  ||  params.title == "")
			listErreurs.add("title is missing")
		// - content
		if (params["post-text"] == null  ||  params["post-text"] == "")
			listErreurs.add("body is missing")
		// - tags
		if (params.strListTags == null  ||  params.strListTags == "")
			listErreurs.add("you need at least one valid tag")
		if (! listErreurs.isEmpty())
			return render(view: "/question/edit", model: [question: question, strListTags: params.strListTags, listErreurs: listErreurs])
		
		try {
			// Modifier la question
			question.title = params.title
			question.content = params["post-text"]
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
			// Affichage
			redirect(url: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/question/edit", model: [question: question, strListTags: params.strListTags, listErreurs: [e.getMessage()]])
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
		// Utilisateur
		// - connecté
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/nonexistent")
		
		try {
			// Supprimer
			QuestionService qService = new QuestionService()
			qService.delete(question)
		} catch (ServiceException e) {
		}
		
		redirect(url: "/question")
	}
	
}
