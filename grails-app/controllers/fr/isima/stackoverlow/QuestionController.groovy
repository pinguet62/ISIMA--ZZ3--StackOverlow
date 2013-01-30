package fr.isima.stackoverlow

/**
 * Controlleur des pages des questions
 * @author Julien
 */
class QuestionController {
	
	/**
	 * Créer une question
	 * @param 
	 * @return Affichage de la question
	 */
	def create() {
		
	}
	
	
	/**
	 * Afficher une question
	 * @param id Identifiant de la question
	 * @return Affichage de la question <br/>
	 *         Page d'erreur si inexistante
	 */
    def show() {
		Question question = Question.findById(params.id)
		
		// DEBUG
		// Session
		User user = new User(name: "userDebugName", mail: "userDebugAdresse@mail.com", password: "userDebugPassword")
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
	 * @return Affiche la liste des questions <br/>
	 *         Page d'erreur si inexistante
	 */
	def all() {
		int page = 1
		if (params.page != null)
			page = params.page.toInteger()
		
		// Paramètre
		int nbParPage = 15
		
		// Liste des questions
		int premier = nbParPage*(page-1)
		int dernier = nbParPage*page -1
		List<Question> listQuestions = new QuestionService().getDesc(premier, dernier)
		if (listQuestions.isEmpty())
			return render(view: "/question/nonexistent")
		
		// Liste des pages
		int nbPages = Math.ceil(Question.count / nbParPage)
		def listPages = []
		if (nbPages <= 3)
			for (int i=1 ; i<=nbPages ; i++)
				listPages.add(i)
		else if (nbPages == 4) {
			if (page == 1)
				listPages = [1, 2, 4]
			else if (page == 2 || page == 3)
				listPages = [1, 2, 3, 4]
			else
				listPages = [1, 3, 4]
		} else {
			if (page == 1)
				listPages = [1, 2, nbPages]
			else if (page == 2)
				listPages = [1, 2, 3, nbPages]
			else if (page == nbPages-1)
				listPages = [1, nbPages-2, nbPages-1, nbPages]
			else if (page == nbPages)
				listPages = [1, nbPages-1, nbPages]
			else
				listPages = [1, page-1, page, page+1, nbPages]
		}
		
		return render(view: "/question/all", model: [listQuestions: listQuestions, currentPage: page, listPages: listPages])
	}
	
}
