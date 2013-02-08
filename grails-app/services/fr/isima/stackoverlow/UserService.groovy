package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * manage the users
 * @author Pierre
 */
class UserService {
	
	/**
	 * Exists 
	 * @param user the user
	 * @return true if user exist in database, false otherwise
	 */
	def exists(User user) {
		return User.findById(user.id) != null
	}
	
	/**
	 * This methode return all the administrator from the database
	 * @return a list of administrator
	 */
	def getAdmin()
	{
		User.findAllByAdmin(true)
	}
	
	/**
	 * This methode return all the users of the database
	 * @return a list of user
	 */
	def getAll()
	{
		return User.list();
	}
	
	
	/**
	 * Disponible
	 * @param name the name to check
	 * @return true if the name is already used false otherwise
	 */
	def disponible(String name) {
		return User.findAllByName(name).size() == 0
	}
	
	
	/**
	 * create
	 * @param user the user to add in database
	 * @exception IllegalArgumentException user already exist
	 * @exception ServiceException if can not save user
	 */
    def create(User user) {
		if (! disponible(user.name))
			throw new IllegalArgumentException("Utilisateur déjà existant")
		
		def obj = user.save()
		
		//check if the user have been saved
		if (obj == null)
			throw new ServiceException("Echec de la création")
    }
	
	
	/**
	 * Update
	 * this method update an user
	 * @param user the user to update
	 * @exception IllegalArgumentException user unknow
	 * @exception ServiceException if can not update the user
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
	 * delete
	 * this methode delete an user
	 * @param user user to delete
	 * @exception IllegalArgumentException unknow user
	 * @exception ServiceException can not delete the user
	 */
	def delete(User user) {
		
		//delete comment about user question and answer
		for (Commentaire com : Commentaire.list())
		{
			if(com.messageVotable.author.id == user.id)
			{
				com.delete()
			}
				
		}
		
		//delete answer about user question
		for (Response response : Response.list()) 
		{
			if(response.question.author.id == user.id)
			{
				//coment of answer
				for (Commentaire com : Commentaire.list())
				{
					if(com.messageVotable.id == response.id )
					{
						com.delete()
					}
				}
				response.delete();
			}
				
		}
		
		//delete of user message and their vote
		List<Message> messages = Message.findAllByAuthor(user)
		for (Message m : messages) 
		{
			for (Vote v : Vote.findAllByMessageVotable(m)) 
			{
				v.delete()	
			}
			m.delete()
		}
		
		//delete the user
		user.delete()
	}
	
	
	/**
	 * GetUserWithMark
	 * get a list of user with a reputation diferent from 0
	 * @return a list of user
	 */
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
	
	/**
	 * getUserActivity
	 * This method return a map of message from a specified user, indexed on date
	 * @param user to get the activity
	 * @return
	 */
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
