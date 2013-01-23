package fr.isima.stackoverlow

abstract class MessageVotable extends Message {
	// Liens avec la BDD
	static hasMany = [commentaires: Commentaire, votes: Vote]
	
    static constraints = { 
    }
}
