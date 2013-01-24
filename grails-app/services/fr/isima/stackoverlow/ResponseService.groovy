package fr.isima.stackoverlow

import fr.isima.stackoverflow.ServiceException

/**
 * Gestion des messages votables (question ou r�ponse)
 * @author Julien
 */
class ResponseService extends MessageVotableService {
	
	/**
	 * Cacher
	 * @param reponse R�ponse
	 */
	def disable(Response reponse) {
		// Cascade
		for (Commentaire commentaire in reponse.commentaires)
			commentaire.disable()
		reponse.disable()
	}
	
	
	/**
	 * Supprimer
	 * @param reponse R�ponse
	 * @exception ServiceException Impossible de supprimer la question
	 */
	def delete(Response reponse) {
		// Cascade
		for (Commentaire commentaire in reponse.commentaires)
			commentaire.delete()
		reponse.delete()
		
		// Echec
		if (Question.findById(question.id) != null)
			throw new ServiceException("Impossible de supprimer la question")
	}
	
}
