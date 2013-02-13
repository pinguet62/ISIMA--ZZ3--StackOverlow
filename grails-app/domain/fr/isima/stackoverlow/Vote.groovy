package fr.isima.stackoverlow

/**
 * Vote positif ou négatif d'un utilisateur sur un message votable
 * @author Julien
 */
class Vote {
	
	// Attributs
	int mark = 0
	
	// Liens avec la BDD
	static belongsTo = [user: User, messageVotable: MessageVotable]
	
	
    static constraints = {
		mark inList: [-1, 0, +1]
    }
	
}
