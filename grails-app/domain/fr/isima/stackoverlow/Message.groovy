package fr.isima.stackoverlow

/**
 * Représente un message que peut écrire un utilisateur
 * @author Julien
 */
abstract class Message {
	
	// Attributs
	String content
	Date date = new Date()
	Boolean display = true
	
	// Liens avec la BDD
	static belongsTo = [author: User]
	
	
    static constraints = {
		content(minSize: 1)
    }
	
}
