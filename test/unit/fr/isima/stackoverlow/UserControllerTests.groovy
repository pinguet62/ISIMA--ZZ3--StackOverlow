package fr.isima.stackoverlow

import org.junit.Before;
import org.junit.Test;

@TestFor(UserController)
@Mock([User, Commentaire, Question, Response, Vote, Message])
class UserControllerTests
{
	fr.isima.stackoverlow.UserController controller = new UserController();
	
	@Before
	void before() {
		User.where{}.deleteAll()
	}
	
	
	
	@Test
	void login() {
		User user1 = new User(name: "user1Name", mail: "user1Adresse@mail.com", password: "user1Password")
		user1.save()
		
		User user2 = new User(name: "user2Name", mail: "user2Adresse@mail.com", password: "user2Password")
		user2.save()
		
		
		this.controller.params.mail = "user1Adresse@mail.com"
		this.controller.params.password="user1Password"
		
		this.controller.login()
		
		//assertEquals "all", this.controller.redirectArgs.action   plus suporter.. comment faire?
		//assertEquals "question", this.controller.redirectArgs.controller
		
		/*def model = this.controller.show()
		assertEquals 'Staff 1', model['staffInstance']?.name
		assertTrue(service.exists(user2))*/
	}
	
	
	
}
