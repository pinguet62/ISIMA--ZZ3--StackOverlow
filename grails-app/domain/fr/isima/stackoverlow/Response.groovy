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
	
	
	/**
	 * R�cup�rer la question associ�e � la r�ponse
	 * @return Question
	 * @author Julien
	 */
	/*def getQuestion() {
		return this.question.id
	}*/
	
}
