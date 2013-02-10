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
		// Utilisateur connect�
		if (! UserController.isConnected())
			return redirect(url: "/user/login")
		
		// R�ponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/notFound", model: [locality: "questions"])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Droits d'�dition
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), response))
			return redirect(url: "/question/"+question.id)
		
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
			return redirect(url: "/user/login")
		
		// R�ponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/notFound", model: [locality: "questions"])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Droits d'�dition
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), response))
			return redirect(url: "/question/"+question.id)
		
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
			return redirect(url: "/question/"+question.id)
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
			return redirect(url: "/user/login")
		
		// R�ponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/notFound", model: [locality: "questions"])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Droits de suppression
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), response))
			return redirect(url: "/question/"+question.id)
		
		try {
			// Supprimer
			ResponseService rService = new ResponseService()
			rService.delete(response)
		} catch (ServiceException e) {
		}
		
		return redirect(url: "/question/"+question.id)
	}
	
}
