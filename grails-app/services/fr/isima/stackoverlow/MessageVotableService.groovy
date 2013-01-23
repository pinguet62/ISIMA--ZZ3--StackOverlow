package fr.isima.stackoverlow

import java.awt.image.renderable.ParameterBlock;

class MessageVotableService {
	
	// Vote positif par l'utilisateur
	def voteUp(User u, MessageVotable m) {
		
		Vote v = null
		for (Vote vote : Vote.where{})
			if (vote.user.id == u.id && vote.messageVotable.id == m.id) {
				v = vote
				break
			}
		
			
		// Utilisateur a déjà voté
		if (v != null) {
			if (v.mark == 1) // déjà voté à +1
				return false
			else if (v.mark == -1) // annuler vote
				v.delete()
		}
		// Nouveau vote
		else {
			v = new Vote(mark: +1,
				user: u,
				messageVotable: m)
			Vote vSaved = v.save()
			if (! vSaved)
				return false
		}
		
		return true
	}
	
	
	// Vote négatif par l'utilisateur
	def voteDown(User u, MessageVotable m) {
		// Utilisateur a déjà voté
		Vote v = Vote.findByUserAndMessageVotable(u, m)
		if (v) {
			if (v.mark == -1) // déjà voté à +1
				return false;
			else if (v.mark == +1) // annuler vote
				v.delete()
		}
		// Nouveau vote
		else {
			v = new Vote(mark: -1,
				user: u,
				messageVotable: m)
			Vote vSaved = v.save()
			if (!vSaved)
				return false
		}
		return true
	}
	
	
	// Obtenir la note totale
	def getMark(MessageVotable m) {
		int note = 0;
		Vote.findByMessageVotable(m).each {
			note += it.mark
		}
		return note
	}
}
