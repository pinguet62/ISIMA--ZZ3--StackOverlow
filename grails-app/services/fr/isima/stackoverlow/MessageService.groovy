package fr.isima.stackoverlow

import fr.isima.stackoverflow.ServiceException

/**
 * Gestion des messages
 * @author Julien
 */
class MessageService {
	
	/**
	 * Cr�er
	 * @param message Message
	 * @exception ServiceException Echec de la cr�ation du message
	 */
	def create(Message message) {
		def obj = message.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la cr�ation du message")
	}
	
	
    /**
	 * Mettre � jour
	 * @param message Message
	 * @exception ServiceException Echec de la mise � jour du message
	 */
	def update(Message message) {
		def obj = message.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la mise � jour du message")
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
	 * @exception ServiceException Echec de la suppression du message
	 */
	def delete(Message message) {
		message.delete()
		
		// Echec
		Class type = message.getClass()
		if (type.findById(message.id) != null)
			throw new ServiceException("Echec de la suppression du message")
	}
	
}
