package fr.isima.stackoverlow

/**
 * Représente une réponse donnée à une question
 * @author Julien
 */
class Response extends MessageVotable {
	
	// Liens avec la BDD
	static belongsTo = [question: Question]
	
	
    static constraints = {
    }
	
	
	
	/**
	 * Récupérer la question associée à la réponse
	 * @return Question
	 * @author Julien
	 */
	/*def getQuestion() {
		return this.question.id
	}*/
	
	
	/**
	 * Représentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('Response: id=%d, question=%d, author=%d, commentaires=%s, votes=%s, date="%s", content="%s"', id, question.id, author.id, commentaires.collect{it.id}, votes.collect{it.id}, date.toString(), content);
	}
	
}
