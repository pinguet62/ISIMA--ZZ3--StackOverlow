package fr.isima.stackoverlow

class UserController {

	static scaffold = true
	
	
	/**
	 * Connexion
	 */
	def login() {
		// TODO
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword") // tmp
		session["user"] = user
	}
	
	
	/**
	 * D�connexion
	 */
	def logOut() {
		// TODO
		session.invalidate()
	}
	
	
    def index() {
		render 'la classe user'
	}
	
	/**
	 * Afficher une question
	 */
	def show() {
		println params.id
		render(view: "/user/index")
	}
	
}
