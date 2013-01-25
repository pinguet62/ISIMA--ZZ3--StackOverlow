package fr.isima.stackoverlow

/**
 * Tag associé à une question qui permet de classer ou de rechercher les différentes questions
 * @author Julien
 *
 */
class Tag {
	
	// Attributs
	String name
	
	// Liens avec la BDD
	//static hasMany = [question: Question]
	
	
    static constraints = {
		name(unique: true, minSize: 1)
    }
	
}