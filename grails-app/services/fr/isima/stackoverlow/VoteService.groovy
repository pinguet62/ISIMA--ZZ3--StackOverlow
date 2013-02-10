package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des votes
 * @author Julien
 */
class VoteService {
	
	/**
	 * Obtenir la réputation d'un utilisateur
	 * @param user Utilisateur
	 * @return Réputation
	 * @TODO Optimiser avec du SQL
	 * @author Julien
	 */
	def getReputation(User user) {
		int rep = 0
		Vote.all.each { vote ->
			if (vote.messageVotable.author.id == user.id)
				rep += vote.mark
		}
		return rep
	}
	
	
	/**
	 * Compute the mark of a message
	 * @param message the message
	 * @return the mark
	 * @author Julien
	 */
	def getMark(MessageVotable message) {
		int note = 0
		Vote.all.each { vote->
			if (vote.messageVotable.id == message.id)
				note += vote.mark
		}
		return note
	}
	
	
	/**
	 * Test si l'utilisateur a voté positivement pour le message
	 * @param message Message
	 * @param user Utilisateur
	 * @return Autorisé
	 */
	def votedUp(MessageVotable message, User user) {
		// Test
		if (user == null)
			return false
		
		Vote vote = Vote.findByUserAndMessageVotable(user, message)
		return (vote != null  &&  vote.mark == +1)
	}
	
	
	/**
	 * Test si l'utilisateur a voté négativement pour le message
	 * @param message Message
	 * @param user Utilisateur
	 * @return Autorisé
	 */
	def votedDown(MessageVotable message, User user) {
		// Test
		if (user == null)
			return false
		
		Vote vote = Vote.findByUserAndMessageVotable(user, message)
		return (vote != null  &&  vote.mark == -1)
	}
	
	
	/**
	 * Vote up
	 * @param message The message
	 * @param user The user
	 * @exception ServiceException Vote pour soi impossible
	 * @exception ServiceException Fail of the vote
	 * @author Julien
	 */
	def voteUp(MessageVotable message, User user) {
		// Vote pour soi
		if (message.author == user)
			throw new ServiceException("Vote pour soi impossible")
		
		Vote vote = Vote.findByUserAndMessageVotable(user, message)
		// Nouveau vote
		if (vote == null) {
			vote = new Vote(mark: +1)
			vote.user = user
			vote.messageVotable = message
			def obj = vote.save()
			// Echec
			if (obj == null)
				throw new ServiceException("Echec du vote")
		}
		// Utilisateur a déjà voté
		else {
			if (vote.mark == +1)
				return
			else if (vote.mark == 0) {
				vote.mark = +1
				def obj = vote.save()
				// Echec
				if (obj == null)
					throw new ServiceException("Echec du vote")
			} else if (vote.mark == -1)
				vote.mark = 0
				vote.save()
				vote.delete()
				// Echec
				if (Vote.findById(vote.id) != null)
					throw new ServiceException("Echec du vote")
		}
	}
	
	
	/**
	 * Vote down
	 * @param message The message to vote
	 * @param user The vote
	 * @exception ServiceException Vote pour soi impossible
	 * @exception ServiceException Fail of the vote
	 * @author Julien
	 */
	def voteDown(MessageVotable message, User user) {
		// Vote pour soi
		if (message.author == user)
			throw new ServiceException("Vote pour soi impossible")
		
		Vote vote = Vote.findByUserAndMessageVotable(user, message)
		// Nouveau vote
		if (vote == null) {
			vote = new Vote(mark: -1)
			vote.user = user
			vote.messageVotable = message
			def obj = vote.save()
			// Echec
			if (obj == null)
				throw new ServiceException("Echec du vote")
		}
		// Utilisateur a déjà voté
		else {
			if (vote.mark == -1)
				return
			else if (vote.mark == 0) {
				vote.mark = -1
				def obj = vote.save()
				// Echec
				if (obj == null)
					throw new ServiceException("Echec du vote")
			} else if (vote.mark == +1)
				vote.mark = 0
				vote.save()
				vote.delete()
				// Echec
				if (Vote.findById(vote.id) != null)
					throw new ServiceException("Echec du vote")
		}
	}
	
	
	def getDetailedReput(User user)
	{
		List<Vote> ret = new ArrayList<Vote>()
		for (Vote vote : Vote.list())
			if (vote.messageVotable.author.equals(user))
				ret.add(vote)
		return ret
		
	}
	
	
	def getVoteFromUser(User user)
	{
		List<Vote> ret = Vote.findAllByUser(user)
		return ret
	}
	
	
	static def getNbVoteStatic(MessageVotable message)
	{
		List<Vote> tmp = Vote.findAllByMessageVotable(message)
		return tmp.size()//.size();
	}
	
}
