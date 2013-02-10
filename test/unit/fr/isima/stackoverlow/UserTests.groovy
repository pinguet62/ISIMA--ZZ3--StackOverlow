package fr.isima.stackoverlow

import grails.test.mixin.*
import org.junit.*

@TestFor(User)
class UserTests {
	
	@Before
	void before() {
		User.where{}.deleteAll()
	}
	
	
	@Test
	void save_update_delete() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		// Save
		assertEquals(User.findAll().size(), 0)
		user.save()
		assertEquals(User.findAll().size(), 1)
		// Update
		String newName = "newUserName"
		String newMail = "newUserAdresse@mail.com"
		String newPassword = "newUserPassword"
		user.name = newName
		user.mail = newMail
		user.password = newPassword
		user.save()
		assertEquals(User.findAll().size(), 1)
		User newUser = User.get(1)
		assertEquals(user.name, newName)
		assertEquals(user.mail, newMail)
		assertEquals(user.password, newPassword)
		// Delete
		user.delete()
		assertEquals(User.findAll().size(), 0)
	}
	
	
	@Test
	void name() {
		// minSize
		assertNull(new User(name: "n", mail: "userAdresse@email.com", password: "userPassword").save())
		// nullable
		assertNull(new User(name: null, mail: "userAdresse@mail.com", password: "userPassword").save())
		// unique
		assertNotNull(new User(name: "userName", mail: "user1Adresse@mail.com", password: "userPassword").save())
		assertNull(new User(name: "userName", mail: "user2Adresse@mail.com", password: "userPassword").save())
	}
	
	
	@Test
	void mail() {
		// email
		assertNull(new User(name: "userName", mail: "a", password: "userPassword").save())
		// nullable
		assertNull(new User(name: "userName", mail:null, password: "userPassword").save())
		// unique
		assertNotNull(new User(name: "user1Name", mail: "userAdresse@mail.com", password: "userPassword").save())
		assertNull(new User(name: "user2Name", mail: "userAdresse@mail.com", password: "userPassword").save())
	}
	
	
	@Test
	void password() {
		// minSize
		assertNull(new User(name: "userName", mail: "userAdresse@email.com", password: "p").save())
		// nullable
		assertNull(new User(name: "userName", mail: "userAdresse@mail.com", password: null).save())
	}
	
}
