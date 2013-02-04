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
	 */
	def all() {
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
		
		return render(view: "/question/all", model: [listQuestions: listQuestions, currentPage: page, listPages: listPages])
	}
	
	
	/**
	 * Afficher une question
	 * @param id Identifiant de la question
	 * @return Page de la question <br/>
	 *         Page d'erreur si inexistante
	 */
    def show() {
		Question question = Question.findById(params.id)
		
		// DEBUG
		User user = new User(name: "userDebugName", mail: "userDebugAdresse@mail.com", password: "userDebugPassword")
		user.save()
		session.user = user
		
		// Inexistante
		if (question == null) {
			return render(view: "/question/nonexistent")
		} else if (! question.display)
			return render(view: "/question/moderationDeleted")
		else
			return render(view: "/question/show", model: [question: question])
	}
	
	
	/**
	 * Afficher la liste des questions
	 * @param page Numéro de page
	 * @return Liste
	 */
	def answer_submit() {
		
		// Passage obligatoire par le formulaire
		if (params["post-text"] == null)
			return render(view: "/question/ask", model: [listErreurs: ["body is missing"]])
		
		
	}
	
	
	/**
	 * Créer une question
	 * Vérifier que l'utilisateur est connecté
	 * @return Page du formulaire
	 */
	def ask() {
		if (! UserController.isConnected())
			return render(view: "/user/login")
		
		return render(view: "/question/ask")
	}
	
	
	/**
	 * Créer une question
	 * Validation du formulaire
	 * @param title Titre
	 * @param post-text Contenu
	 * @param listTags Liste des tags
	 * @return Page de la question
	 */
	def ask_submit() {
		// Tests
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
			for (String name : params.listTags.split(" +")) {
				Tag tag = tService.getOrCreate(name)
				question.addToTags(tag)
			}
			// Sauvegarder
			QuestionService qService = new QuestionService()
			qService.create(question)
			// Affichage
			return render(view: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/question/ask", model: [listErreurs: [e.getMessage()]])
		}
	}
	
}
