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
	
}
