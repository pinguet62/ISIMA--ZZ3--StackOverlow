package fr.isima.stackoverlow

class Commentaire extends Message {
	// Liens avec la BDD
	static belongsTo = [messageVotable: MessageVotable]
	
    static constraints = {
    }
}
