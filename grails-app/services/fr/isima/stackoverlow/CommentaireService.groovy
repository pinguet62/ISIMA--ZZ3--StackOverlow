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
	 * Obtenir la liste des commentaires tri�s
	 * @param message Message
	 * @return Liste de commentaires
	 * @author Julien
	 */
	def get(MessageVotable message) {
		return Commentaire.executeQuery(	"""
												SELECT commentaire
												FROM Commentaire commentaire
												WHERE commentaire.messageVotable = :message
												ORDER BY commentaire.date ASC
											""", [message: message])
	}
	
}
