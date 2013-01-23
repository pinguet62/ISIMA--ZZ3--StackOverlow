package fr.isima.stackoverlow

abstract class Message {
	// Attributs
	String content
	Boolean display = true
	Date date =  new Date()
	
	// Liens avec la BDD
	static belongsTo = [user: User]
	
    static constraints = {
    }
}
