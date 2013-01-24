package fr.isima.stackoverlow

import fr.isima.stackoverflow.ServiceException

/**
 * Gestion des utilisateurs
 * @author Julien
 */
class UserService {
	
	/**
	 * Existant
	 * @param user Utilisateur
	 * @return Vrai ou Faux
	 */
	def exists(User user) {
		return User.find(user) != null
	}
	
	
	/**
	 * Nom disponible
	 * @param name Nom d'utilisateur
	 * @return Vrai ou Faux
	 */
	def disponible(String name) {
		return User.findAllByName(name).size() == 0
	}
	
	
	/**
	 * Cr�ation
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur d�j� existant
	 * @exception ServiceException Impossible de cr�er l'utilisateur
	 */
    def create(User user) {
		// Test
		if (! disponible(user.getName()))
			throw new IllegalArgumentException("Utilisateur d�j� existant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Impossible de cr�er l'utilisateur")
    }
	
	
	/**
	 * Mettre � jour
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur innexistant
	 * @exception ServiceException Impossible de mettre � jour l'utilisateur
	 */
	def update(User user) {
		// Test
		if (! exists(user))	
			throw new IllegalArgumentException("Utilisateur inexistant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Impossible de mettre � jour l'utilisateur")
	}
	
	
	/**
	 * Supprimer
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur innexistant
	 * @exception ServiceException Impossible de supprimer l'utilisateur
	 */
	def delete(User user) {
		// Test
		if (! exists(user))
			throw new IllegalArgumentException("Utilisateur inexistant")
		
		user.delete()
		
		// Echec
		if (exists(user))
			throw new ServiceException("Impossible de supprimer l'utilisateur")
	}
	
}
