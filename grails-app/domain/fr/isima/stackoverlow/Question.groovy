package fr.isima.stackoverlow

/**
 * Représente une question qui est la source d'une discussion
 * @author Julien
 */
class Question extends MessageVotable {
	
	// Attributs
	String title
	
	// Liens avec la BDD
	static hasMany = [responses: Response, tags: Tag]
	
	
    static constraints = {
		title(unique: true, minSize: 1)
    }
	
}
