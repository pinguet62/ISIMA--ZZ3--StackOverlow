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
		session["user"] = user
		// Question
		User userQ = new User(name: "userQName", mail: "userQAdresse@mail.com", password: "userQPassword")
		question = new Question(title: "titleQ", content: "contentQ", date: new Date())
		question.author = userQ
		// Tags
		Tag tag1 = new Tag(name: "tag1")
		question.addToTags(tag1)
		Tag tag2 = new Tag(name: "tag2")
		question.addToTags(tag2)
		//     Commentaires 1
		User userQC1 = new User(name: "userQC1Name", mail: "userQC1Adresse@mail.com", password: "userQC1Password")
		userQC1.save()
		Commentaire commentaireQC1 = new Commentaire(content: "contentQC1", date: new Date())
		commentaireQC1.author = userQC1
		commentaireQC1.messageVotable = question
		//commentaireQC1.save()
		//     Commentaires 1
		User userQC2 = new User(name: "userQC2Name", mail: "userQC2Adresse@mail.com", password: "userQC2Password")
		Commentaire commentaireQC2 = new Commentaire(content: "contentQC2", date: new Date())
		commentaireQC2.author = userQC2
		commentaireQC2.messageVotable = question
		question.addToCommentaires(commentaireQC2)
		// Reponse 1
		User userR1 = new User(name: "userR1Name", mail: "userR1Adresse@mail.com", password: "userR1Password")
		Response responseR1 = new Response(content: "contentR1", date: new Date())
		responseR1.author = userR1
		responseR1.question = question
		question.addToResponses(responseR1)
		//     Commentaires 1
		User userR1C1 = new User(name: "userR1C1Name", mail: "userR1C1Adresse@mail.com", password: "userR1C1Password")
		Commentaire commentaireR1C1 = new Commentaire(content: "contentR1C1", date: new Date())
		commentaireR1C1.author = userR1C1
		commentaireR1C1.messageVotable = responseR1
		responseR1.addToCommentaires(commentaireR1C1)
		//     Commentaires 2
		User userR1C2 = new User(name: "userR1C2Name", mail: "userR1C2Adresse@mail.com", password: "userR1C2Password")
		Commentaire commentaireR1C2 = new Commentaire(content: "contentR1C2", date: new Date())
		commentaireR1C2.author = userR1C2
		commentaireR1C2.messageVotable = responseR1
		responseR1.addToCommentaires(commentaireR1C2)
		// Reponse 2
		User userR2 = new User(name: "userR2Name", mail: "userR2Adresse@mail.com", password: "userR2Password")
		Response responseR2 = new Response(content: "contentR2", date: new Date())
		responseR2.author = userR2
		responseR2.question = question
		question.addToResponses(responseR2)
		//     Commentaires 1
		User userR2C1 = new User(name: "userR2C1Name", mail: "userR2C1Adresse@mail.com", password: "userR2C1Password")
		Commentaire commentaireR2C1 = new Commentaire(content: "contentR2C1", date: new Date())
		commentaireR2C1.author = userR2C1
		commentaireR2C1.messageVotable = responseR2
		responseR2.addToCommentaires(commentaireR2C1)
		//     Commentaires 2
		User userR2C2 = new User(name: "userR2C2Name", mail: "userR2C2Adresse@mail.com", password: "userR2C2Password")
		Commentaire commentaireR2C2 = new Commentaire(content: "contentR2C2", date: new Date())
		commentaireR2C2.author = userR2C2
		commentaireR2C2.messageVotable = responseR2
		responseR2.addToCommentaires(commentaireR2C2)
		println "question"
		// Inexistante
		if (question == null) {
			return render(view: "/question/error", model: [session: session])
		}
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
