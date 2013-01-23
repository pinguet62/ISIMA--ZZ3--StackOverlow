package fr.isima.stackoverlow

class Response extends MessageVotable {
	// Liens avec la BDD
	static belongsTo = [question: Question]
	
    static constraints = {
    }
}
