package fr.isima.stackoverlow

/**
 * Tag associé à une question qui permet de classer ou de rechercher les différentes questions
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
	 * Représentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('Tag: id=%d, name="%s", questions=%s, description="%s"', id, name, questions.collect{it.id}, description)
	}
	
}