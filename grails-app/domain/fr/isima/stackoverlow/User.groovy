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
		name unique: true, minSize: 5
		mail unique: true, email: true
		password minSize: 5
		avatarUrl nullable: true
    }
	
	
	/**
	 * Représentation sous forme de String
	 * @return String
	 */
	String toString() {
		return String.format("Name: %s, Mail: %s, Password: %s, Admin: %s", name, mail, password, admin.toString())
	}
	
}
