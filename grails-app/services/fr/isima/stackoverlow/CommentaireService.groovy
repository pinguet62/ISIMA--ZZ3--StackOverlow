package fr.isima.stackoverlow

import fr.isima.stackoverflow.ServiceException
import fr.isima.stackoverlow.Commentaire
import fr.isima.stackoverlow.MessageVotable

/**
 * Gestion des commentaires des différents messages
 * @author Julien
 */
class CommentaireService {
	
	/**
	 * Ajouter un commentaire à un message votable
	 * @param message Message commentable
	 * @param commentaire Commentaire
	 */
    def add(MessageVotable message, Commentaire commentaire) {
		message.commentaires.add(commentaire)
    }
	
	
	/**
	 * Cacher un commentaire
	 * @param commentaire Commentaire
	 */
	def disable(Commentaire commentaire) {
		commentaire.display = false
	}
	
	
	/**
	 * Supprimer un commentaire
	 * @param commentaire Commentaire
	 * @exception ServiceException Impossible de supprimer le commentaire
	 */
	def delete(Commentaire commentaire) {
		commentaire.delete()
		
		// Echec
		if (Commentaire.findAllById(commentaire.getId()).size != 0)
			throw new ServiceException("Impossible de supprimer le commentaire")
	}
	
}
