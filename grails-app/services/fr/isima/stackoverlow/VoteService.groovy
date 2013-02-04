package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des votes
 * @author Julien
 */
class VoteService {
	
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
	
	
	/**
	 * Obtenir la réputation d'un utilisateur
	 * @param user Utilisateur
	 * @return Réputation
	 * @TODO Optimiser avec du SQL
	 * @author Julien
	 */
	def getReputation(User user) {
		int rep = 0
		Vote.all.each { vote->
			if (vote.messageVotable.author.id == user.id)
				rep += vote.mark
		}
		return rep
		
		/*def res = Vote.executeQuery("SELECT sum(v.mark) FROM Vote AS v AND Question AS q WHERE v.messageVotable = q AND q.author = :u", [u: user])
		if (res[0] == null)
			return 0
		else
			return res[0]*/
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
	 * Vote up
	 * @param message the message
	 * @param user the user
	 * @exception ServiceException if the vote fail
	 * @author Julien
	 */
	def voteUp(MessageVotable message, User user) {
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
	 * @param message the message to vote
	 * @param user the vote
	 * @exception ServiceException fail of the vote
	 * @author Julien
	 */
	def voteDown(MessageVotable message, User user) {
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
	
}
