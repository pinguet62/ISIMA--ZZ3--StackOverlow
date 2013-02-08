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
	 * This method is called when the user want to sign-in
	 * @param void
	 * @return question page if successfull, login form if not
	 */
	def login() {
		def serv = new UserService();
		
		// get information from the form
		def mail = params.mail
		def password = params.password
		def u = User.findByMailAndPassword(mail,password)
		if (u!= null && serv.exists(u)) 
		{
			//user can login
			logUser(u)
		}
		else 
		{
			//user cannot login
			def message = message(code: "user.login.wronglogin");
			return render(view:"/user/loginForm",model: [message:message])
		}
	}
	
	/**
	 * this method open a session for the user passed on parameter
	 * @param user the user to login
	 * @return to question page
	 */
	def logUser(User user) 
	{
		session.user = user
		return redirect(controller: 'question', action:'all')
	}
	
	/**
	 * logout
	 * this method log-out the current loged user
	 * @return Index of site
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
	 * get the user logged in
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
		//get wich information to display
		def param=params.tab
		if(param==null)
		{
			//if not specified, the default view is "summary"
			param = "sum"
		}
		//get the user to show
		def userid=params.id;
		
		//check if the user reealy exist
		User user = User.findById(userid)
		if (user == null) 
		{
			//if the user doesn't exist, redirect to the error page
			Exception e = new Exception("Cette utilisateur n'existe pas");
			return render(view: "/error",model: [exception: e])
		}
		//if the user exist, we get all the information to display
		QuestionService Qserv 	= new QuestionService()
		ResponseService Rserv 	= new ResponseService()
		VoteService Vserv 		= new VoteService()
		TagService Tserv 		= new TagService()
		UserService Userv		= new UserService()
		
		//get reputation information, vote, questions, responses, activity and tag information
		def reput = Vserv.getReputation(user)
		List<Vote> lstVR		= Vserv.getDetailedReput(user)
		List<Vote> lstV			= Vserv.getVoteFromUser(user)
		List<Question> lstQ		= Qserv.getQuestionFromUser(user)
		List<Response> lstR		= Rserv.getResponseFromUser(user)
		Map<Integer,Tag> lstT 	= Tserv.getTagFromUser(user)
		Map<Date,List<Message>> lstA 	= Userv.getUserActivity(user)
		
		//extract a sample of the previous information to display in the summary
		Map<Integer,Tag> lstT4 	= new HashMap<Integer,Tag>()
		List<Vote> lstVR4 		= new ArrayList<Vote>()
		List<Response> lstR4 	= new ArrayList<Response>()
		List<Question> lstQ4 	= new ArrayList<Question>()
		
		//sample for responses, questions, reputation details
		for(int i = 0; i<4; ++i)
		{
			if(lstR.size()>i)
				lstR4.add(lstR.get(i));
			if(lstQ.size()>i)
				lstQ4.add(lstQ.get(i));
			if(lstVR.size()>i)
				lstVR4.add(lstVR.get(i));
		}
		
		//sample for tags of the user
		int i=0
		int nbtag=0
		for (Integer cle : lstT.keySet()) 
		{
			if(i < 10)
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
		
		//redirect to the view with data
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
	 * @param sort: used to select which user is display
	 * @return render to the users page
	 * 
	 */
	def all() 
	{	//get the sorting parameter
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
				lst = serv.getAll()
				break;
			
			case "mark": 
				lst = serv.getUserWithMark()
				break;
			
			case "admin":
				lst = serv.getAdmin()
				break;		
			default: 
				lst = serv.getAll();
				break;
		}
		//render the view with data
		return render(view: "/user/all", model: [listUsers: lst, view: param])
	}
	
	/**
	 * create an user
	 * @return the questions page if success
	 * 	an error message the the create form if error
	 */
	def create()
	{
		//get data from the form
		def name = params.username
		def urlProf = params.profile
		def password =  params.password1
		def mail = params.mail
		def admin = false
		
		//create the user
		User u = new User()
		u.name = name
		u.mail = mail
		u.avatarUrl = urlProf
		u.password = password
		u.admin = admin

		UserService serv = new UserService()
		
		try
		{
			//try to save the user
			User ret = serv.create(u)
			//loggin the new user
			logUser(u)
		}
		catch(Exception e)
		{
			//if an error occurs, rending the form with error message
			def erreur=""
			if(e.getClass() == IllegalArgumentException.class )
			{
				erreur=message(code: "user.create.userexist")
			}
			else
			{
				erreur=message(code: "user.create.creationfailed")
			}
			return render(view:"/user/newUser",model: [message:erreur])
		}
	}
	
	
	/**
	 * delete an user
	 * @param the user id to delete
	 * @return render the users list
	 */
	def delete()
	{
		//get the id to delete
		def iduser=params.id
		//get the user to delete
		def userDel = User.findById(iduser)

		//if the user is log, we log him out
		if(session.user.id == userDel.id)
		{
			session.user=null
		}
		
		UserService userv = new UserService()
		userv.delete(userDel)
		//redirect to users list
		return redirect(url: "/user")
	}
	
	
	/**
	 * update an user in database
	 * @return render Index
	 */
	def updateUser()
	{
		//get data from the form
		def iduser = params.iduser
		def name = params.username
		def urlProf = params.profile
		def password =  params.password1
		def mail = params.mail
		def relog=false;
		
		//get the edited user
		User u = User.findById(iduser)
		//if the edited user if the logged user
		if(u.id == session.user.id)
		{
			//we log him out
			session.user = null
			relog=true;
		}
		
		//updating data
		u.name = name
		u.mail = mail
		u.avatarUrl = urlProf
		u.password = password
		
		UserService serv = new UserService()
		try
		{
			//saving the news values
			u.save()
			if(relog) //if we have log out the user, we re-log him in
			{
				session.user = u
			}
			//we redirect to the user's page
			return redirect(url: "/user/"+u.id)
		}
		catch(Exception e)
		{
			//if we can't edit the user, we show why in the editing form
			return render(view:"/user/newUser",model: [message:e.getMessage()])
		}
	}
	
	
	/**
	 * the method is used to initiate the editing-form values
	 * @return render to editing form with user data
	 */
	def edit()
	{
		def id=params.id
		//get the user to edit
		User user = User.findById(id)
		//rendering the edit form
		return render(view:"/user/editUser",model: [userEdit:user])
	}
	
	/**
	 * This method redirect to the rules page
	 * @return
	 */
	def rules()
	{
		return render(view:"/user/rules");
	}
}
