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
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/notFound", model: [locality: "questions"])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Droits d'édition
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), response))
			return redirect(url: "/question/"+question.id)
		
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
			return redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/notFound", model: [locality: "questions"])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Droits d'édition
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), response))
			return redirect(url: "/question/"+question.id)
		
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
			return redirect(url: "/question/"+question.id)
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
			return redirect(url: "/user/login")
		
		// Réponse
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
