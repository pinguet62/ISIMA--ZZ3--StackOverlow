package fr.isima.stackoverlow

import javax.servlet.http.HttpSession

class UserController {
	
	/**
	 * Connexion
	 * @param TODO
	 */
	def login() {
		def serv = new UserService();
		
		// Retour du formulaire
		def name = ""
		def password = ""
		
		def u = User.findByName(name)
		
		if (serv.exists(u)) {
			//session ouverte
			session.user = u
			//return u // il faut faire render() vers une page :p
			//this.
			
		}
		else {
			//refus ouverture session
			//return null // il faut faire render() vers une page :p
			ServiceException exp = new ServiceException("Wrong authenification")
			render(view:"/error",exception:exp)
		}
	}
	
	
	/**
	 * Déconnexion
	 * @return Index du forum
	 * @TODO Retourner vers la page précédente
	 */
	def logout() {
		println "Logout"
		
		session.user = null
		render(view: "/index")
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
		return render(view: "/user/show", model: [user: user])
	}
	
	
	/**
	 * Afficher la liste des utilisateurs
	 * @return Liste
	 */
	def all() {
		List<User> lst = User.list();
		return render(view: "/user/all", model: [listUsers: lst])
	}
	
}
