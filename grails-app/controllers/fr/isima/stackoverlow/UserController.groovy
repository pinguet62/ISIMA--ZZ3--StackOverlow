package fr.isima.stackoverlow

import javax.servlet.http.HttpSession

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Controller of User's pages
 * @author Julien
 */
class UserController {
	
	/**
	 * Login method
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
			return render(view:"/index")
			
		}
		else {
			//refus ouverture session
			ServiceException exp = new ServiceException("Wrong authenification")
			return render(view:"/error",exception:exp)
		}
	}
	
	
	/**
	 * logout
	 * @return Index of site
	 * @TODO Retourner vers la page précédente
	 */
	def logout() {
		println "Logout"
		
		session.user = null
		return render(view: "/index")
	}
	
	
	/**
	 * check if a user is connected
	 * @return true or false
	 */
	static def isConnected() {
		return new UserController().session.user != null
	}
	
	
	/**
	 * get the user
	 * @return the current user <br/>
	 *         null if he is not connected
	 */
	static def getUser() {
		return new UserController().session.user
	}
	
	
	/**
	 * display a user profile
	 * @param id user id
	 * @return display the profile <br/>
	 *         error page if not exist
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
	 * Display a list of all users
	 * @return render to the users page
	 * 
	 */
	def all() {
		def param=params.sort
		List<User> lst=null;
		UserService serv = new UserService();
		switch(param)
		{
			case "mark": 
				lst = serv.getUserWithMark();
				break;
			
			case "admin":
				lst = User.findByAdmin(true);
				break;		
			default: 
				lst = User.list();
				break;
		}
		
		return render(view: "/user/all", model: [listUsers: lst])
	}
	
	/**
	 * create an user
	 * @return render Index
	 */
	def createUser()
	{
		//retour du formulaire
		def name = ""
		def password = ""
		def mail =""
		def admin = false
		
		User u = new User()
		u.name = name
		u.mail = mail
		u.password = password
		u.admin = admin
		
		UserService serv = new UserService()
		serv.create(u)
		this.login()
		return render(view: "/index")
	}
	
	/**
	 * delete an user
	 * @return render Index
	 */
	def deleteUser()
	{
		//retou de formulaire
		def name = ""
		def password = ""
		def mail =""
		def admin = false
		
		User u = new User()
		UserService serv= new UserService()
		serv.delete(u)
		return render(view: "/index")
	}
	
	
	/**
	 * delete an user
	 *{@link TODO} faire en sorte de redirigé sur la page précedente
	 * @return render Index
	 */
	def updateUser()
	{
		//retour de formulaire
		def name = ""
		def password = ""
		def mail =""
		def admin = false
		
		User u = new User()
		UserService serv= new UserService()
		serv.update(u)
		return render(view: "/index")
	}
	
	
	
	
	
	
}
