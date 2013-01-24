package fr.isima.stackoverlow

/**
 * Représente une question qui est la source d'une discussion
 * @author Julien
 */
class Question extends MessageVotable {
	
	// Attributs
	String titre
	
	// Liens avec la BDD
	static hasMany = [responses: Response, tag: Tag]
	
    static constraints = {
    }
	
}
