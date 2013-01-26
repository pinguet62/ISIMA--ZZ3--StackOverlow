package fr.isima.stackoverlow

import javax.servlet.http.HttpSession;

class UserController {

	static scaffold = true // ?
	
	
	/**
	 * Connexion
	 */
	def login() {
		// TODO
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword") // tmp
		session["user"] = user
	}
	
	
	/**
	 * Déconnexion
	 */
	def logOut() {
		// TODO
		session.invalidate()
	}
	
	
	/**
	 * Test si l'utilisateur est connecté
	 * @return Vrai ou Faux
	 */
	static def isConnected() {
		return new UserController().session.user != null
	}
	
	
	/**
	 * Obtenir l'utilisateur
	 * @return Utilisateur <br/>
	 *         null s'il n'est pas connecté
	 */
	static def getUser() {
		return new UserController().session.user
	}
	
	
	/**
	 * Afficher un profil
	 * @param id Identifiant de l'utilisateur
	 * @return Affichage du profil <br/>
	 *         Page d'erreur si inexistant
	 */
	def show() {
		User user = User.findById(params.id)
		// Inexistante
		if (user == null) {
			return render(view: "/user/error")
		}
		render(view: "/user/show", model: [user: user])
	}
	
	
	/**
	 * Afficher la liste des utilisateurs
	 * @return Liste
	 */
	def all() {
		// TODO
		render(view: "/user/all")
	}
	
}
