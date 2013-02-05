package fr.isima.stackoverlow

class ResponseController {
	
	/**
	 * Editer une r�ponse
	 * @param id Identifiant de la r�ponse
	 * @return Page du formulaire <br/>
	 *         Page de connexion si l'utilisateur n'est pas connect�
	 * @author Julien
	 */
	def edit() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// R�ponse
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
	 * Valider l'�dition d'une r�ponse
	 * @param id Identifiant de la r�ponse
	 * @param post-text Contenu
	 * @param strListTags Liste des noms des tags
	 * @return Page de la question <br/>
	 *         Page du formulaire si erreur
	 * @author Julien
	 */
	def edit_submit() {
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// R�ponse
		Response response = Response.findById(params.id)
		if (response == null) {
			return render(view: "/question/nonexistent")
		} else if (! response.display)
			return render(view: "/question/moderationDeleted")
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// V�rifier le formulaire
		def listErreurs = []
		// - content
		if (params["post-text"] == null  ||  params["post-text"] == "")
			listErreurs.add("body is missing")
		if (! listErreurs.isEmpty())
			return render(view: "/response/edit", model: [reponse: response, question: question, listErreurs: listErreurs])
		
		try {
			// Modifier la r�ponse
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
	 * Supprimer une r�ponse
	 * @param id Identifiant de la r�ponse
	 * @return Page de la question <br/>
	 *         Page de connexion si l'utilisateur n'est pas connect�
	 * @author Julien
	 */
	def delete() {
		// Utilisateur
		// - connect�
		if (! UserController.isConnected())
			redirect(url: "/user/login")
		
		// R�ponse
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
