package fr.isima.stackoverlow

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
			return render(view: "/question/show", model: [session: session, question: question])
	}
	
	
	/**
	 * Afficher la liste des questions
	 * @return Liste
	 */
	def all() {
		// TODO
	}
	
}
