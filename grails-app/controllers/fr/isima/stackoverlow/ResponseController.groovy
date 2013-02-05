package fr.isima.stackoverlow

class ResponseController {
	
	/**
	 * Editer une réponse
	 * @param id Identifiant de la réponse
	 * @return Page du formulaire <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def edit() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null) {
			return render(view: "/question/nonexistent")
		} else if (! response.display)
			return render(view: "/question/moderationDeleted")
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		return render(view: "/response/edit", model: [reponse: response, question: question])
	}
	
	
	/**
	 * Valider l'édition d'une réponse
	 * @param id Identifiant de la réponse
	 * @param post-text Contenu
	 * @param strListTags Liste des noms des tags
	 * @return Page de la question <br/>
	 *         Page du formulaire si erreur
	 * @author Julien
	 */
	def edit_submit() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null) {
			return render(view: "/question/nonexistent")
		} else if (! response.display)
			return render(view: "/question/moderationDeleted")
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Vérifier le formulaire
		def listErreurs = []
		// - content
		if (params["post-text"] == null  ||  params["post-text"] == "")
			listErreurs.add("body is missing")
		if (! listErreurs.isEmpty())
			return render(view: "/response/edit", model: [reponse: response, question: question, listErreurs: listErreurs])
		
		try {
			// Modifier la réponse
			response.content = params["post-text"]
			// Sauvegarder
			ResponseService rService = new ResponseService()
			rService.update(response)
			// Affichage
			redirect(url: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/response/edit", model: [reponse: response, question: question, listErreurs: [e.getMessage()]])
		}
	}
	
	
	/**
	 * Supprimer une réponse
	 * @param id Identifiant de la réponse
	 * @return Page de la question <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def delete() {
		// Utilisateur
		// - connecté
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/question/nonexistent")
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		try {
			// Supprimer
			ResponseService rService = new ResponseService()
			rService.delete(response)
		} catch (ServiceException e) {
		}
		
		redirect(url: "/question/"+question.id)
	}
	
}
