package fr.isima.stackoverlow

import grails.test.mixin.*
import org.junit.*

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
	void test() {
		// Question
		// - utilisateur
		User userQ = new User(name:"userQName", mail:"userQAdresse@mail.com", password:"userQPassword")
		userQ.save()
		assertEquals(User.list().size(), 1)
		assertNotNull(User.findById(userQ.id))
		// - question
		Question question = new Question(title: "titleQ", content: "contentQ", date: new Date())
		question.author = userQ
		question.save()
		assertEquals(Question.list().size(), 1)
		assertEquals(User.findById(userQ.id).messages.size(), 1)
		
		// Réponse
		// - utilisateur
		User userR = new User(name:"userRName", mail:"userRAdresse@mail.com", password:"userRPassword")
		userR.save()
		assertNotNull(User.findById(userR.id))
		// - réponse
		Response response = new Response(content: "contentR", date: new Date())
		response.author = userR
		response.question = question
		response.save()
		assertNotNull(Response.findById(response.id))
		assertEquals(User.findById(userR.id).messages.size(), 1)
		assertEquals(Question.findById(question.id).responses.size(), 1)
	}
	
}
