package fr.isima.stackoverlow

/**
 * Controlleur des votes
 * @author Julien
 */
class VoteController {
	
	/**
	 * Méthode appelée lorsque l'utilisateur appuie sur un bouton de vote positif
	 * @param id Identifiant du message
	 * @return Code HTML de la case du vote positif
	 */
	def up() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Message
		MessageVotable message = MessageVotable.findById(params.id)
		if (message == null)
			return redirect(url: "/question") // TODO
		
		try {
			// Vote positif
			VoteService vService = new VoteService()
			vService.voteUp(message, UserController.getUser())
		} catch (ServiceException e) {
		}
		
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(message)
		
		return redirect(url: "/question/"+question.id)
	}
	
	
	/**
	 * Méthode appelée lorsque l'utilisateur appuie sur un bouton de vote positif
	 * @param id Identifiant du message
	 * @return Code HTML de la case du vote positif
	 */
	def down() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/logUser") // return redirect(url: "/user/login")
		
		// Message
		MessageVotable message = MessageVotable.findById(params.id)
		if (message == null)
			return redirect(url: "/question") // TODO
		
		try {
			// Vote négatif
			VoteService vService = new VoteService()
			vService.voteDown(message, UserController.getUser())
		} catch (ServiceException e) {
		}
		
		// Question
		MessageService mService = new MessageService()
		Question question = mService.getQuestion(message)
		
		return redirect(url: "/question/"+question.id)
	}
	
}
