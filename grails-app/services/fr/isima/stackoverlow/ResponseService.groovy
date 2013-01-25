package fr.isima.stackoverlow

import fr.isima.stackoverflow.ServiceException

/**
 * Gestion des messages votables (question ou réponse)
 * @author Julien
 */
class ResponseService extends MessageVotableService {
	
	/**
	 * Cacher
	 * @param reponse Réponse
	 */
	def disable(Response reponse) {
		// Cascade
		for (Commentaire commentaire in reponse.commentaires)
			commentaire.disable()
		reponse.disable()
	}
	
	
	/**
	 * Supprimer
	 * @param reponse Réponse
	 * @exception ServiceException Echec de la suppression du message
	 */
	def delete(Response reponse) {
		// Cascade
		for (Commentaire commentaire in reponse.commentaires)
			commentaire.delete()
		reponse.delete()
		
		// Echec
		if (Question.findById(reponse.id) != null)
			throw new ServiceException("Echec de la suppression du message")
	}
	
}
