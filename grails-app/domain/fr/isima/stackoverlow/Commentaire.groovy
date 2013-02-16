package fr.isima.stackoverlow

/**
 * Repr�sente un commentaire que peut laisser un utilisateur � un message votable (question ou r�ponse)
 * @author Julien
 */
class Commentaire extends Message {
	
	// Liens avec la BDD
	static belongsTo = [messageVotable: MessageVotable]
	
	
    static constraints = {
    }
	
	
	/**
	 * R�cup�rer la question associ�e au commentaire
	 * @return Question
	 * @author Julien
	 */
	/*def getQuestion() {
		return messageVotable.getQuestion()
	}*/
	
	
	/**
	 * Repr�sentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('Commentaire: id=%d, messageVotable=%d, author=%d, date="%s", content="%s"', id, messageVotable.id, author.id, date.toString(), content);
	}
	
}
