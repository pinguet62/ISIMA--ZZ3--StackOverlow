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
		User user1 = new User(name:'name1', mail:'adresse1@mail.com', password:'password1')
		User user2 = new User(name:'name2', mail:'adresse2@mail.com', password:'password2').save()
		
		assertFalse(service.exists(user1))
		assertTrue(service.exists(user2))
	}
	
	
	@Test
    void disponible() {
        User user = new User(name:'name', mail:'adresse@mail.com', password:'password').save()
		
		assertFalse(service.disponible(user.getName()))
		assertTrue(service.disponible("inconnu"))
    }
	
	
	@Test
	void create() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		
		assertTrue(service.disponible(user.getName()))
		service.create(user);
		assertFalse(service.disponible(user.getName()))
	}
	
	
	@Test
	void delete() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password').save()
		
		assertTrue(service.exists(user))
		service.delete(user);
		assertFalse(service.exists(user))
	}
	
}
