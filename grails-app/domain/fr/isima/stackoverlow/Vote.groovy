package fr.isima.stackoverlow

/**
 * Vote positif ou négatif d'un utilisateur sur un message votable
 * @author Julien
 */
class Vote {
	
	// Attributs
	int mark = 0
	
	// Liens avec la BDD
	static belongsTo = [user: User, messageVotable: MessageVotable]
	
	
    static constraints = {
		mark inList: [-1, 0, +1]
    }
	
	
	/**
	 * Représentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('Vote: id=%d, mark=%s, user=%d, messageVotable=%d', id, (mark==+1?"+1":(mark==0?"0":"-1")), user.id, messageVotable.id)
	}
	
}
