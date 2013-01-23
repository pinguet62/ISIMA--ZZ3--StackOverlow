package fr.isima.stackoverlow

class User {
	// Attributs
	String name
	String mail
	String password
	
	// Liens avec la BDD
	static hasMany = [vote:Vote, message:Message]
	
	static constraints = {
    }
}
