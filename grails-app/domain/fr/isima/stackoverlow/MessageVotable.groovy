package fr.isima.stackoverlow

/**
 * Repr�sente un message qui peut �tre vot� et comment� par un utilisateur
 * @author Julien
 */
 class MessageVotable extends Message {
	
	// Liens avec la BDD
	static hasMany = [commentaires: Commentaire, votes: Vote]
	
	
	/**
	 * Repr�sentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('MessageVotable: id=%d, author=%d, commentaires=%s, votes=%s, date="%s", content="%s"', id, author.id, commentaires.collect{it.id}, votes.collect{it.id}, date.toString(), content);
	}
	
}
