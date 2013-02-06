package fr.isima.stackoverlow

import javax.servlet.http.HttpSession

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Controller of User's pages
 * @author Pierre
 */
class UserController {
	
	/**
	 * Login method
	 */
	def login() {
		def serv = new UserService();
		
		// Retour du formulaire
		def mail = params.mail
		def password = params.password
		
		def u = User.findByMailAndPassword(mail,password)
		
		if (u!= null && serv.exists(u)) {
			logUser(u)
			
		}
		else {
			def message = "mot de passe et / ou login invalide"
			//refus ouverture session
			//ServiceException exp = new ServiceException("Wrong authenification")
			return render(view:"/user/loginForm",model: [message:message])
		}
	}
	
	
	def logUser(User user) 
	{
		session.user = user
		return redirect(controller: 'question', action:'all')
	}
	
	/**
	 * logout
	 * @return Index of site
	 * @TODO Retourner vers la page précédente
	 */
	def logout() {
		session.user = null
		return redirect(controller: 'question', action:'all')
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
	def show() 
	{
		def param=params.tab
		if(param==null)
		{
			param = "sum"
		}
		User user = User.findById(params.id)
		// Inexistante
		if (user == null) {
			return render(view: "/user/error")
		}
		QuestionService Qserv 	= new QuestionService()
		ResponseService Rserv 	= new ResponseService()
		VoteService Vserv 		= new VoteService()
		TagService Tserv 		= new TagService()
		UserService Userv		= new UserService()
		
		def reput = Vserv.getReputation(user)
		List<Vote> lstVR		= Vserv.getDetailedReput(user)
		List<Vote> lstV			= Vserv.getVoteFromUser(user)
		List<Question> lstQ		= Qserv.getQuestionFromUser(user)
		List<Response> lstR		= Rserv.getResponseFromUser(user)
		Map<Integer,Tag> lstT 	= Tserv.getTagFromUser(user)
		Map<Date,List<Message>> lstA 	= Userv.getUserActivity(user)
		
		Map<Integer,Tag> lstT4 	= new HashMap<Integer,Tag>()
		List<Vote> lstVR4 		= new ArrayList<Vote>()
		List<Response> lstR4 	= new ArrayList<Response>()
		List<Question> lstQ4 	= new ArrayList<Question>()
		
		for(int i = 0; i<4; ++i)
		{
			if(lstR.size()>i)
				lstR4.add(lstR.get(i));
			if(lstQ.size()>i)
				lstQ4.add(lstQ.get(i));
			if(lstVR.size()>i)
				lstVR4.add(lstVR.get(i));
		}
		
		int i=0;
		int nbtag=0;
		for (Integer cle : lstT.keySet()) 
		{
			if(i<10)
			{
				lstT4.put(cle, new ArrayList<Tag>())
				for (Tag t : lstT.get(cle)) 
				{
					nbtag+=cle;
					lstT4.get(cle).add(t)
				}
			}
			
			++i;
		}
		
		//stat for votes
		int voteUp = 0;
		int voteDown = 0;
		int questions = 0;
		int responses = 0;
		for (Vote vote : lstV) 
		{
			if(vote.mark == 1)
			{
				++voteUp
			}
			else
			{
				++voteDown
			}
			
			if(vote.messageVotable.hasProperty("title"))
			{
				++questions
			}
			else
			{
				++responses
			}
		}
		
		
		return render(view: "/user/show", model: [usersel: user,
			reput: reput,
			lstQ: lstQ, 
			lstR: lstR, 
			lstR4: lstR4, 
			lstQ4: lstQ4,
			lstVR4: lstVR4,
			lstVR: lstVR,
			lstT4: lstT4,
			lstT: lstT,
			lstA: lstA, 
			nbtag: nbtag,
			voteDown: voteDown,
			questions: questions,
			responses:responses,
			voteUp: voteUp,
			param: param ])
	}
	
	
	/**
	 * Display a list of all users
	 * @return render to the users page
	 * 
	 */
	def all() {
		def param=params.sort
		if(param==null)
		{
			param="nofilter"
		}
		List<User> lst=null;
		UserService serv = new UserService();
		switch(param)
		{
			case "nofilter":
				lst = User.list();
				break;
			
			case "mark": 
				lst = serv.getUserWithMark();
				break;
			
			case "admin":
				lst = User.findAllByAdmin(true);
				break;		
			default: 
				lst = User.list();
				break;
		}
		
		return render(view: "/user/all", model: [listUsers: lst, view: param])
	}
	
	/**
	 * create an user
	 * @return render Index
	 */
	def create()
	{
		//retour du formulaire
		def name = params.username
		def urlProf = params.profile
		def password =  params.password1
		def mail = params.mail
		def admin = false
		
		User u = new User()
		u.name = name
		u.mail = mail
		u.avatarUrl = urlProf
		u.password = password
		u.admin = admin
		
		//System.out.println(name + " " +password + " " + mail );
		
		UserService serv = new UserService()
		
		try{
			User ret = serv.create(u)
			logUser(u)
		}
		catch(Exception e)
		{
			
			return render(view:"/user/newUser",model: [message:e.getMessage()])
		}
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
		def name = params.username
		def urlProf = params.profile
		def password =  params.password1
		def mail = params.mail
		
		
		User u = User.findById(session.user.id)
		session.user = null
		
		u.name = name
		u.mail = mail
		u.avatarUrl = urlProf
		u.password = password
		
		
		
		UserService serv = new UserService()
		try{
			
			u.save()
			session.user = u
			params.id=u.id
			return redirect(controller: "user", action: "show")
		}
		catch(Exception e)
		{
			
			return render(view:"/user/newUser",model: [message:e.getMessage()])
		}
	}
	
	
	def edit()
	{
		
		User user = session.user
		return render(view:"/user/editUser",model: [userEdit:user])
		
		
	}
	
	
	
}
