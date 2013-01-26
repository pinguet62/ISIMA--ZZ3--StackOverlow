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
	
	
	/**
	 * Représentation sous forme de String
	 * @return String
	 */
	/*String toString() {
		String res = String.format("Title: \"%s\", Content: \"%s\", Date: %s, Author: %s", title, content, date, author.name)
		res = res + ", Responses: ["
		for (Response response : responses)
			res += response.id + " "
		res = res + "]"
		res = res + ", Tags: ["
		for (Tag tag : tags)
			res = res + tag.id + " "
		res = res + "]"
		return res
	}*/
}
