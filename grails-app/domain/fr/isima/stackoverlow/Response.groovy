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
	
	
	/**
	 * Repr�sentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('Response: id=%d, question=%d, author=%d, commentaires=%s, votes=%s, date="%s", content="%s"', id, question.id, author.id, commentaires.collect{it.id}, votes.collect{it.id}, date.toString(), content);
	}
	
}
