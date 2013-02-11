package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des messages
 * @author Julien
 */
class MessageService {
	
	/**
	 * Obtenir la question associée au message
	 * @param message Message (question, réponse ou commentaire)
	 * @return Question
	 * @exception ServiceException Question introuvable
	 * @author Julien
	 */
	def getQuestion(Message message) {
		if (message instanceof Question)
			return message
		else if (message instanceof Response)
			return message.question
		else if (message instanceof Commentaire)
			if (message.messageVotable instanceof Question)
				return message.messageVotable
			else if (message.messageVotable instanceof Response)
				return message.messageVotable.question
		throw new ServiceException("Question introuvable")
	}
	
	
	/**
	 * Créer
	 * @param message Message
	 * @exception ServiceException Echec de la création du message
	 * @author Julien
	 */
	def create(Message message) {
		def obj = message.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la création du message")
	}
	
	
    /**
	 * Mettre à jour
	 * @param message Message
	 * @exception ServiceException Echec de la mise à jour du message
	 * @author Julien
	 */
	def update(Message message) {
		def obj = message.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la mise à jour du message")
	}
	
	
	/**
	 * Supprimer
	 * @param message Message
	 * @exception ServiceException Echec de la suppression du message
	 * @author Julien
	 */
	def delete(Message message) {
		message.delete()
		
		// Echec
		Class type = message.getClass()
		if (type.findById(message.id) != null)
			throw new ServiceException("Echec de la suppression du message")
	}
	

	def isQuestion(Message message) {
		return message instanceof Question
	}
	def isResponse(Message message) {
		return message instanceof Response
	}
	def isCommentaire(Message message) {
		return message instanceof Commentaire
	}

	
}
