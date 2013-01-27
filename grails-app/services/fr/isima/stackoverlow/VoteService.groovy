package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

// TODO
class VoteService {
	
	/**
	 * Calculer la note d'un utilisateur
	 * @param user Utilisateur
	 * @return Note
	 */
	def getMark(User user) {
		int note = 0
		for (Vote vote : Vote.list())
			if (vote.messageVotable.author.equals(user))
				note += vote.mark
		return note
	}
	
	
	/**
	 * Calculer la note d'un message
	 * @param message Message
	 * @return Note
	 */
	def getMark(MessageVotable message) {
		return VoteService.getMarkStatic(message)
	}
	
	
	/**
	 * Calculer la note d'un message
	 * @param message Message
	 * @return Note
	 */
	static def getMarkStatic(MessageVotable message) {
		int note = 0
		Vote.findByMessageVotable(message).each {
			note += it.mark
		}
		return note
	}
	
	
	/**
	 * Vote positif
	 * @param message Message
	 * @param user Utilisateur
	 * @exception ServiceException Echec du vote
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
	 * Vote négatif
	 * @param message Message
	 * @param user Utilisateur
	 * @exception ServiceException Echec du vote
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
