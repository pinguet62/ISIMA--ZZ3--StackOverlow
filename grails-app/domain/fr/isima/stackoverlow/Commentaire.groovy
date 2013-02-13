package fr.isima.stackoverlow

/**
 * Représente un commentaire que peut laisser un utilisateur à un message votable (question ou réponse)
 * @author Julien
 */
class Commentaire extends Message {
	
	// Liens avec la BDD
	static belongsTo = [messageVotable: MessageVotable]
	
	
    static constraints = {
    }
	
	
	/**
	 * Récupérer la question associée au commentaire
	 * @return Question
	 * @author Julien
	 */
	/*def getQuestion() {
		return messageVotable.getQuestion()
	}*/
	
}
