package fr.isima.stackoverlow

import javax.servlet.http.HttpSession;

class UserController {

	static scaffold = true // ?
	
	
	/**
	 * Connexion
	 */
	def login() {
		def serv = new UserService();
		
		//retour du formulaire
		def name = ""
		def password = ""
		
		def u = User.findByName(name)
		
		if(serv.exists(u))
		{
			//session ouverte
			session[u] = true
			return u
			
		}
		else
		{
			//refus ouverture session
			return null
		}
		
	}
	
	
	/**
	 * Déconnexion
	 */
	def logOut(User u) {
		session[u] = false
	}
	
	
	/**
	 * Test si l'utilisateur est connecté
	 * @return Vrai ou Faux
	 */
	def isConnected(User u) {
		return session[u]== true
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
		
		List<User> lst = User.list();
		render(view: "/user/all")
	}
	
}
