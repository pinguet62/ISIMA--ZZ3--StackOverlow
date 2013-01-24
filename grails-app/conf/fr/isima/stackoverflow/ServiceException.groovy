package fr.isima.stackoverflow

/**
 * Exception levée lorsqu'une erreur est survenue lors d'une action d'un service
 * @author Julien
 */
class ServiceException extends Exception {
	
	/**
	 * Constructeur
	 * @param message Message de l'erreur
	 */
	def ServiceException(String message) {
		super(message)
	}
	
}
