package fr.isima.stackoverlow

class MessageVotableService {
	// Vote positif par l'utilisateur
	def voteUp(User u, MessageVotable m) {
		Vote v = null;
		for (Vote vote : Vote.findAll())
			if (vote.user.equals(u) && vote.messageVotable.equals(m)) {
				v = vote
				break
			}
		
		//Vote v = Vote.findAll //AllByUserAndMessageVotable(u, m)
		// Utilisateur a déjà voté
		if (v) {
			if (v.mark == 1) // déjà voté à +1
				return false;
			else if (v.mark == -1) // annuler vote
				v.delete()
		}
		// Nouveau vote
		else {
			v = new Vote(mark: +1,
				user: u,
				messageVotable: m)
			Vote vSaved = v.save()
			if (!vSaved)
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
