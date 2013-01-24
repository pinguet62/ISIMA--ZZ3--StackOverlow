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
	 * Création
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur déjà existant
	 * @exception ServiceException Impossible de créer l'utilisateur
	 */
    def create(User user) {
		// Test
		if (! disponible(user.getName()))
			throw new IllegalArgumentException("Utilisateur déjà existant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Impossible de créer l'utilisateur")
    }
	
	
	/**
	 * Mettre à jour
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur innexistant
	 * @exception ServiceException Impossible de mettre à jour l'utilisateur
	 */
	def update(User user) {
		// Test
		if (! exists(user))	
			throw new IllegalArgumentException("Utilisateur inexistant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Impossible de mettre à jour l'utilisateur")
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
