package fr.isima.stackoverlow

import fr.isima.stackoverflow.ServiceException

/**
 * Gestion des messages
 * @author Julien
 */
class MessageService {
	
	/**
	 * Créer une nouvelle question
	 * @param message Message
	 * @exception Impossible de créer la question
	 */
	def create(Message message) {
		def obj = message.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Impossible de créer le message")
	}
	
	
    /**
	 * Mettre à jour
	 * @param message Message
	 * @exception ServiceException Impossible de mettre à jour le message
	 */
	def update(Message message) {
		def obj = message.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Impossible de mettre à jour le message")
	}
	
	
	/**
	 * Cacher
	 * @param message Message
	 */
	def disable(Message message) {
		message.display = false
	}
	
	
	/**
	 * Supprimer
	 * @param message Message
	 * @exception ServiceException Impossible de supprimer le message
	 */
	def delete(Message message) {
		message.delete()
		
		// Echec
		Class type = message.getClass()
		if (type.findById(message.id) != null)
			throw new ServiceException("Impossible de supprimer le message")
	}
	
}
