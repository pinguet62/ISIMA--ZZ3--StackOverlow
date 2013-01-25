package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(Response)
@Mock([User, Question])
class ResponseTests {
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
		Response.where{}.deleteAll()
	}
	
	
	@Test
	void message() {
		User user = new User(name:"userName", mail:"userAdresse@mail.com", password:"userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Response response = new Response(content: "content", date: new Date())
		response.author = user
		response.question = question
		response.save()
		
		assertEquals(Response.findAll().size(), 1)
	}
	
}
