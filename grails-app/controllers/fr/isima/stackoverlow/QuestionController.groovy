package fr.isima.stackoverlow

class QuestionController {
	
	/**
	 * Afficher une question
	 * @param id Identifiant de la question
	 * @return Affichage de la question <br/>
	 *         Page d'erreur si inexistante
	 */
    def show() {
		Question question = Question.findById(params.id)
		
		// DEBUG
		User user1 = new User(name: "user1Name", mail: "user1Adresse@mail.com", password: "user1Password")
		User user2 = new User(name: "user2Name", mail: "user2Adresse@mail.com", password: "user2Password")
		User user3 = new User(name: "user3Name", mail: "user3Adresse@mail.com", password: "user3Password")
		question = new Question(title: "Titre inconnu car question d'un con nul", content: "Bonjour.<br/>Voici le contenu de ma question<br/>Pouriez-vous ne pas m'aider ?<br/>Merci", date: new Date())
		question.author = user1
		Response response1 = new Response(content: "Voici ma reponse<br/>En fait je n'en ai pas", date: new Date())
		response1.author = user2
		response1.question = question
		Response response2 = new Response(content: "Ah ça tombe bien !<br/>Je n'en ai pas non-plus", date: new Date())
		response2.author = user3
		response2.question = question
		
		// Inexistante
		if (question == null) {
			return render(view: "/question/error", model: [message: "Question inexistante"])
		}
		return render(view: "/question/show", model: [question: question])
	}
	
}
