package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

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
	 * @exception ServiceException Echec de la cr�ation
	 */
    def create(User user) {
		// Test
		if (! disponible(user.name))
			throw new IllegalArgumentException("Utilisateur d�j� existant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la cr�ation")
    }
	
	
	/**
	 * Mettre � jour
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur innexistant
	 * @exception ServiceException Echec de la mise � jour
	 */
	def update(User user) {
		// Test
		if (! exists(user))	
			throw new IllegalArgumentException("Utilisateur inexistant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la mise � jour")
	}
	
	
	/**
	 * Supprimer
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur innexistant
	 * @exception ServiceException Echec de la suppression
	 */
	def delete(User user) {
		// Test
		if (! exists(user))
			throw new IllegalArgumentException("Utilisateur inexistant")
		
		user.delete()
		
		// Echec
		if (exists(user))
			throw new ServiceException("Echec de la suppression")
	}
	
	
	
	def getUserWithMark()
	{
		def votes= Vote.list()
		
		List<User> lst = new ArrayList<User>()
		
		
		for (Vote v : votes) {
			if(!lst.contains(v.user))
			{
				lst.add(v.user)
			}	
		}
		
		return lst
	
	}
	
}
