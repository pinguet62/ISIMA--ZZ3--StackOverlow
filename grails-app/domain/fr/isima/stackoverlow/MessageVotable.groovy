package fr.isima.stackoverlow

/**
 * Repr�sente un message qui peut �tre vot� et comment� par un utilisateur
 * @author Julien
 */
 class MessageVotable extends Message {
	
	// Liens avec la BDD
	static hasMany = [commentaires: Commentaire, votes: Vote]
	
	
    static constraints = { 
    }
	
	
	/*User getQuestionAuthor() {
	}*/
	
}
