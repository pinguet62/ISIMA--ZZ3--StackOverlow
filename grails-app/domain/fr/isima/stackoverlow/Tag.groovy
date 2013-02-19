package fr.isima.stackoverlow

/**
 * Tag associ� � une question qui permet de classer ou de rechercher les diff�rentes questions
 * @author Julien
 *
 */
class Tag {
	
	// Attributs
	String name
	String description
	
	// Liens avec la BDD
	static hasMany = [questions: Question]
	static belongsTo = Question
	
	
    static constraints = {
		name unique: true, blank: false, minSize: 1
		description nullable: true
    }
	
	
	/**
	 * Repr�sentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('Tag: id=%d, name="%s", questions=%s, description="%s"', id, name, questions.collect{it.id}, description)
	}
	
}