package fr.isima.stackoverlow

class Vote {
	// Attributs
	int mark = 0
	
	// Liens avec la BDD
	static belongsTo = [user:User, messageVotable:MessageVotable]
	
    static constraints = {
    }
}
