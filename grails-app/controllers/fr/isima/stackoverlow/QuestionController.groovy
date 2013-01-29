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
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
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
	def all() {
		int page = 1
		if (params.page == null)
			page = params.page
		
		int nbParPage = 15
		
		// Liste des questions
		int premier = nbParPage*(page-1)
		int dernier = nbParPage*page -1
		List<Question> listQuestions = new QuestionService().getDesc(premier, dernier)
		
		// Liste des pages
		
		return render(view: "/question/all", model: [listQuestions: listQuestions])
	}
	
}
