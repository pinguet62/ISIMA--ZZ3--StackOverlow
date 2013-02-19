package fr.isima.stackoverlow

/**
 * Utilisateur
 * @author Julien
 */
class User {
	
	// Attributs
	String name
	String mail
	String password
	Boolean admin = false
	String avatarUrl
	
	// Liens avec la BDD
	static hasMany = [votes: Vote, messages: Message]
	
	
	static constraints = {
		name unique: true, blank: false, minSize: 5
		mail unique: true, blank: false, email: true
		password blank: false, minSize: 5
		avatarUrl nullable: true
    }
	
	
	/**
	 * Représentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format('User: id=%d, name="%s", mail="%s", password="%s", admin=%s, votes=%s, messages=%s, avatarUrl="%s"', id, name, mail, password, admin.toString(), votes.collect{it.id}, messages.collect{it.id}, avatarUrl)
	}
	
}
