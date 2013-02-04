package fr.isima.stackoverlow

/**
 * Controlleur des pages des questions
 * @author Julien
 */
class QuestionController {
	
	/**
	 * Afficher la liste des questions
	 * @param page Numéro de page
	 * @param pagesize Nombre de questions par page
	 * @return Page des questions <br/>
	 *         Page d'erreur si inexistante
	 * @author Julien
	 */
	def all() {
		// DEBUG
		User user = new User(name: "userDebugName", mail: "userDebugAdresse@mail.com", password: "userDebugPassword")
		user.save()
		session.user = user
		
		// Paramètres
		// - numéro de page
		int page = 1
		if (params.page != null) {
			page = params.page.toInteger()
			session.question_page = page
		} else if (session.question_page != null)
			page = session.question_page
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
		int premier = pagesize*(page-1)
		int quantite = pagesize
		def listQuestions = new QuestionService().getDesc(premier, quantite)
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
		// DEBUG
		User user = new User(name: "userDebugName", mail: "userDebugAdresse@mail.com", password: "userDebugPassword")
		user.save()
		session.user = user
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null) {
			return render(view: "/question/nonexistent")
		} else if (! question.display)
			return render(view: "/question/moderationDeleted")
		else
			return render(view: "/question/show", model: [question: question])
	}
	
	
	/**
	 * Afficher la liste des questions
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
	 * Vérifier que l'utilisateur est connecté
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
	 * Créer une question
	 * Validation du formulaire
	 * @param title Titre
	 * @param post-text Contenu
	 * @param listTags Liste des tags
	 * @return Page de la question <br/>
	 *         Page du formulaire si erreur
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
		if (params.listTags == null  ||  params.listTags == "")
			listErreurs.add("you need at least one valid tag")
		if (! listErreurs.isEmpty())
			return render(view: "/question/ask", model: [listErreurs: listErreurs])
		
		try {
			// Créer la question
			Question question = new Question(title: params.title, content: params["post-text"], date: new Date())
			question.author = UserController.getUser()
			TagService tService = new TagService()
			for (String name : params.listTags.split(" +"))
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
	
}
