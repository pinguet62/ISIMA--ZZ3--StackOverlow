package fr.isima.stackoverlow

import fr.isima.stackoverflow.ServiceException
import fr.isima.stackoverlow.Commentaire
import fr.isima.stackoverlow.MessageVotable

/**
 * Gestion des commentaires des diff�rents messages
 * @author Julien
 */
class CommentaireService extends MessageService {
	
	/**
	 * Ajouter � un message votable
	 * @param message Message commentable
	 * @param commentaire Commentaire
	 * @exception ServiceException Impossible de cr�er le commentaire
	 */
    def add(MessageVotable message, Commentaire commentaire) {
		def obj = commentaire.save()
		if (obj == null)
			throw new ServiceException("Impossible de cr�er le commentaire")
		
		message.addToCommentaires(commentaire)
		
		// Echec
		// TODO
    }
	
}
