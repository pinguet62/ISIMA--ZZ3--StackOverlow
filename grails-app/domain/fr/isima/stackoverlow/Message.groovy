package fr.isima.stackoverlow

/**
 * Représente un message que peut écrire un utilisateur
 * @author Julien
 */
abstract class Message {
	
	// Attributs
	String content
	Boolean display = true
	Date date = new Date()
	
	// Liens avec la BDD
	static belongsTo = [user: User]
	
    static constraints = {
    }
	
}
