package fr.isima.stackoverlow

class ResponseController {
	
	/**
	 * Valider la création d'une réponse
	 * @param id Identifiant de la question
	 * @param content Contenu de la réponse
	 * @return Page de la question
	 * @author Julien
	 */
	def create_submit() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Question
		Question question = Question.findById(params.id)
		if (question == null)
			return render(view: "/question/erreur", model: [error: "Question inexistante."])
		
		// Vérifier le formulaire
		if (params.content == null  ||  params.content == "")
			return render(view: "/question/erreur", model: [error: "Passage par le formulaire obligatoire."])
		
		try {
			// Créer
			Response response = new Response(content: params.content, date: new Date())
			response.author = UserController.getUser()
			response.question = question
			// Sauvegarder
			ResponseService rService = new ResponseService()
			rService.create(response)
			// Afficher
			return redirect(url: "/question/"+question.id)
		} catch (ServiceException e) {
			return render(view: "/question/erreur", model: [error: e.getMessage()])
		}
	}
	
	
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
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/question/erreur", model: [error: "Réponse inexistante."])
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
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/question/erreur", model: [error: "Réponse inexistante."])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Droits d'édition
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), response))
			return redirect(url: "/question/"+question.id)
		
		// Vérifier le formulaire
		def listErreurs = []
		// - content
		if (params.content == null  ||  params.content == "")
			listErreurs.add("body is missing")
		if (! listErreurs.isEmpty())
			return render(view: "/response/edit", model: [reponse: response, question: question, listErreurs: listErreurs])
		
		try {
			// Modifier la réponse
			response.content = params.content
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
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Réponse
		Response response = Response.findById(params.id)
		if (response == null)
			return render(view: "/question/erreur", model: [error: "Réponse inexistante."])
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(response)
		
		// Droits de suppression
		if (! new UserService().isAuthorOrAdmin(UserController.getUser(), response))
			return render(view: "/question/erreur", model: [error: "Vous devez être l'author ou un administrateur pour pouvoir supprimer la réponse."])
		
		try {
			// Supprimer
			ResponseService rService = new ResponseService()
			rService.delete(response)
		} catch (ServiceException e) {
		}
		
		return redirect(url: "/question/"+question.id)
	}
	
}
