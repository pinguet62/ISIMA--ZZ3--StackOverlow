package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException
import fr.isima.stackoverlow.Commentaire
import fr.isima.stackoverlow.MessageVotable

/**
 * Gestion des commentaires des différents messages
 * @author Julien
 */
class CommentaireService extends MessageService {
	
	/**
	 * Ajouter à un message votable
	 * @param message Message commentable
	 * @param commentaire Commentaire
	 * @exception ServiceException Echec de la création du commentaire
	 * @exception ServiceException Echec de l'ajout du commentaire
	 */
    def add(MessageVotable message, Commentaire commentaire) {
		def obj = commentaire.save()
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la création du commentaire")
		
		message.addToCommentaires(commentaire)
		// Echec
		if (Commentaire.findByMessageVotableAndId(message, commentaire.id) == null)
			throw new ServiceException("Echec de l'ajout du commentaire")
    }
	
}
