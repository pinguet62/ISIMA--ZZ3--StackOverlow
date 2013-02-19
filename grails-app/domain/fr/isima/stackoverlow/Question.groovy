package fr.isima.stackoverlow

/**
 * Repr�sente une question qui est la source d'une discussion
 * @author Julien
 */
class Question extends MessageVotable {
	
	// Attributs
	String title
	
	// Liens avec la BDD
	static hasMany = [tags: Tag, responses: Response]
	
	
    static constraints = {
		title unique: true, blank: false, length: 1..256
		//tags unique: true, minSize: 1
    }
	
	
	static mapping = {
		title type: "text"
	}
	
	
	/**
	 * R�cup�rer la question associ�e au message
	 * @return Question
	 * @author Julien
	 */
	/*def getQuestion() {
		return this
	}*/
	
	
	/**
	 * Repr�sentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format("Question: id=%d, title=\"%s\", author=%d, tags=%s, responses=%s, commentaires=%s, votes=%s, date=\"%s\", content=\"%s\"", id, title, author.id, tags.collect{it.id}, responses.collect{it.id}, commentaires.collect{it.id}, votes.collect{it.id}, date.toString(), content);
	}
	
}
