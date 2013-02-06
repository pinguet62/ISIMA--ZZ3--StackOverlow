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
		return User.findById(user.id) != null
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
	 * @exception ServiceException Echec de la création
	 */
    def create(User user) {
		// Test
		if (! disponible(user.name))
			throw new IllegalArgumentException("Utilisateur déjà existant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la création")
    }
	
	
	/**
	 * Mettre à jour
	 * @param user Utilisateur
	 * @exception IllegalArgumentException Utilisateur innexistant
	 * @exception ServiceException Echec de la mise à jour
	 */
	def update(User user) {
		// Test
		if (! exists(user))	
			throw new IllegalArgumentException("Utilisateur inexistant")
		
		def obj = user.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la mise à jour")
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
		def users= User.list()
		
		List<User> lst = new ArrayList<User>()
		VoteService vserv = new VoteService()
		
		for (User user : users) 
		{
			def note = vserv.getReputation(user)
			if(note != 0)
			{
				lst.add(user)
			}	
		}
		
		
		return lst
	
	}
	
	
	def getUserActivity(User u)
	{
		Map<Date,List<Message>> mapRet = new HashMap<Date,List<Message>>()
		
		MessageService Serv = new MessageService()
		
		Message.findAllByAuthor(u).each 
		{
			if(!mapRet.containsKey(it.date))
			{
				mapRet.put(it.date, new ArrayList<Message>())
			}
			mapRet.get(it.date).add(it)
		}
		return mapRet
	}
	
}
