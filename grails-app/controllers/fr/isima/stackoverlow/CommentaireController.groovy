package fr.isima.stackoverlow

class CommentaireController {
	
	/**
	 * Créer un commentaire
	 * @param id Identifiant du message
	 * @param content Contenu
	 * @return Page de la question <br/>
	 *         Page d'erreur si inexistante
	 * @author Julien
	 */
    def create_submit() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Message
		MessageVotable message = MessageVotable.findById(params.id)
		if (message == null)
			return render(view: "/notFound", model: [locality: "questions"])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(message)
		
		try {
			// Commentaire
			Commentaire commentaire = new Commentaire(content: params.content)
			commentaire.author = UserController.getUser()
			commentaire.messageVotable = message
			message.addToCommentaires(commentaire)
			// Sauvegarder
			CommentaireService cService = new CommentaireService()
			cService.create(message)
		} catch (ServiceException e) {
		}
		
		return redirect(url: "/question/"+question.id)
	}
	
}
