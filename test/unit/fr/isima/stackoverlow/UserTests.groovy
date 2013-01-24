package fr.isima.stackoverlow

import org.junit.Test

@TestFor(User)
class UserTests {
	
	@Before
	public void before() {
		User.where{}.deleteAll()
	}
	
	
	@Test
    void create() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		
		def obj = user.save()
		assertNotNull(obj)
		
		assertEquals(User.getAll().size(), 1)
		assertEquals(User.get(1), user)
    }
	
	
	@Test
	void delete() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		
		user.save()
		
		user.delete()
		assertEquals(User.getAll().size(), 0)
	}
	
	
	@Test
	void update() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		user.save()
		
		String newName = "newName"
		user.setName(newName)
		user.save()
		assertEquals(User.get(1).getName(), newName)
	}
	
}
