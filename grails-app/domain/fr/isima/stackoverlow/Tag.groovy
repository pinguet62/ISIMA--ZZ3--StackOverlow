package fr.isima.stackoverlow

/**
 * Tag associ� � une question qui permet de classer ou de rechercher les diff�rentes questions
 * @author Julien
 *
 */
class Tag {
	
	// Attributs
	String name
	
	// Liens avec la BDD
	// TODO
	static hasMany = [question: Question]
	static belongsTo = Question
	
	
    static constraints = {
		name(unique: true, minSize: 1)
    }
	
}