package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des votes
 * @author Julien
 */
class VoteService {
	
	/**
	 * Compute the mark of a user
	 * @param user the user
	 * @return mark
	 */
	def getMark(User user) {
		def res = Vote.executeQuery("SELECT sum(v.mark) FROM Vote AS v WHERE v.user = :u", [u: user])
		if (res[0] == null)
			return 0
		else
			return res[0]
	}
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
	 */
	def getMark(MessageVotable message) {
		def res = Vote.executeQuery("SELECT sum(v.mark) FROM Vote AS v WHERE v.messageVotable = :m", [m: message])
		if (res[0] == null)
			return 0
		else
			return res[0]
	}
	
	
	/**
	 * Vote up
	 * @param message the message
	 * @param user the user
	 * @exception ServiceException Impossible de voter pour soi
	 * @exception ServiceException if the vote fail
	 */
	def voteUp(MessageVotable message, User user) {
		// Test
		// - l'utilisateur vote pour son propre message
		if (message.author.id == user.id)
			throw new ServiceException("Impossible de voter pour soi")
		
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
	 * @exception ServiceException Impossible de voter pour soi
	 * @exception ServiceException fail of the vote
	 */
	def voteDown(MessageVotable message, User user) {
		// Test
		// - l'utilisateur vote pour son propre message
		if (message.author.id == user.id)
			throw new ServiceException("Impossible de voter pour soi")
		
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
