package fr.isima.stackoverlow

/**
 * Repr�sente un message que peut �crire un utilisateur
 * @author Julien
 */
 class Message {
	
	// Attributs
	String content
	Date date = new Date()
	Boolean display = true
	
	// Liens avec la BDD
	static belongsTo = [author: User]
	
	
    static constraints = {
		content minSize: 1, length: 1..10240
    }
	
	
	static mapping = {
		content type: "text"
	}
	
}
