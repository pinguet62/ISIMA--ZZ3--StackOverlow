package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(UserService)
@Mock([User])
class UserServiceTests {
	
	UserService service = new UserService()
	
	
	@Before
	void before() {
		User.where{}.deleteAll()
	}
	
	
	@Test
	void exist() {
		User user1 = new User(name: "user1Name", mail: "user1Adresse@mail.com", password: "user1Password")
		assertFalse(service.exists(user1))
		
		User user2 = new User(name: "user2Name", mail: "user2Adresse@mail.com", password: "user2Password")
		user2.save()
		assertTrue(service.exists(user2))
	}
	
	
	@Test
    void disponible() {
        User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		assertFalse(service.disponible(user.getName()))
		assertTrue(service.disponible("inconnu"))
    }
	
	
	@Test
	void create() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		assertTrue(service.disponible(user.getName()))
		
		service.create(user);
		assertFalse(service.disponible(user.getName()))
	}
	
	
	@Test
	void delete() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		assertTrue(service.exists(user))
		
		service.delete(user);
		assertFalse(service.exists(user))
	}
	
}
