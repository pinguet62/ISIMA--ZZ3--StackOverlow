package fr.isima.stackoverlow

/**
 * Repr�sente une r�ponse donn�e � une question
 * @author Julien
 */
class Response extends MessageVotable {
	
	// Liens avec la BDD
	static belongsTo = [question: Question]
	
	
    static constraints = {
    }
	
}
