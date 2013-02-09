package fr.isima.stackoverlow

/**
 * Représente un message qui peut être voté et commenté par un utilisateur
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
