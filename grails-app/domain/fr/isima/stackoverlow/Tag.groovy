package fr.isima.stackoverlow

class Tag {
	// Attributs
	String name
	
	// Liens avec la BDD
	static belongsTo = [question: Question]
	
    static constraints = {
    }
}
