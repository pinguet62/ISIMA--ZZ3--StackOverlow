package fr.isima.stackoverlow

/**
 * Représente un message que peut écrire un utilisateur
 * @author Julien
 */
 class Message {
	
	// Attributs
	String content
	Date date = new Date()
	
	// Liens avec la BDD
	static belongsTo = [author: User]
	
	
    static constraints = {
		content minSize: 1, length: 1..10240
    }
	
	
	static mapping = {
		content type: "text"
	}
	
	
	/**
	 * Représentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('Message: id=%d, author=%d, date="%s", content="%s"', id, author.id, date.toString(), content);
	}
	
}
