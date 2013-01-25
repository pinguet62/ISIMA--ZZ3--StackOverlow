package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(ResponseService)
@Mock([User, Question, Response])
class ResponseServiceTests {
	
	ResponseService service = new ResponseService()
	
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
		Response.where{}.deleteAll()
	}
	
	
	@Test
	void create() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Response response = new Response(content: "content", date: new Date())
		response.author = user
		response.question = question
		
		service.create(response)
		assertEquals(Response.list().size(), 1)
	}
	
	
	@Test
	void update() {
		// Création
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Response response = new Response(content: "content", date: new Date())
		response.author = user
		response.question = question
		
		service.create(response)
		
		String newContent = "newContent"
		response.content = newContent
		service.update(response)
		
		Response rModif = Response.findById(response.id)
		assertEquals(rModif.content, newContent)
	}
	
	
	@Test
	void disable() {
		// TODO
	}
	
	
	@Test
	void delete() {
		// TODO
	}
	
}
