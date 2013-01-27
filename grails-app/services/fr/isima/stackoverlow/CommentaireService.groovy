package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException
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
	 * @exception ServiceException Echec de la cr�ation du commentaire
	 * @exception ServiceException Echec de l'ajout du commentaire
	 */
    def add(MessageVotable message, Commentaire commentaire) {
		def obj = commentaire.save()
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la cr�ation du commentaire")
		
		message.addToCommentaires(commentaire)
		// Echec
		if (Commentaire.findByMessageVotableAndId(message, commentaire.id) == null)
			throw new ServiceException("Echec de l'ajout du commentaire")
    }
	
}
