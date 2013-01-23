package fr.isima.stackoverlow

class Question extends MessageVotable {
	// Attributs
	String titre
	
	// Liens avec la BDD
	static hasMany = [responses: Response, tag: Tag]
	
    static constraints = {
    }
}
