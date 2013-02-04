package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

// TODO
class VoteService {
	
	/**
	 * Compute the mark of a user
	 * @param user the user
	 * @return mark
	 */
	def getMark(User user) {
		int note = 0
		for (Vote vote : Vote.list())
			if (vote.messageVotable.author.equals(user))
				note += vote.mark
		return note
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
	
	/**
	 * Compute the mark of a message
	 * @param message the message
	 * @return the mark
	 */
	def getMark(MessageVotable message) {
		return VoteService.getMarkStatic(message)
	}
	
	
	/**
	 * Compute the mark of a message but static
	 * @param message the message
	 * @return the mark
	 */
	static def getMarkStatic(MessageVotable message) {
		int note = 0
		Vote.findByMessageVotable(message).each {
			note += it.mark
		}
		return note
	}
	
	
	static def getNbVoteStatic(MessageVotable message)
	{
		List<Vote> tmp = Vote.findAllByMessageVotable(message) 
		return tmp.size()//.size();
	}
	
	/**
	 * Vote up
	 * @param message the message
	 * @param user the user
	 * @exception ServiceException if the vote fail
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
