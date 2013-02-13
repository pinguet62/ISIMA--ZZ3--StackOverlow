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
	
}
