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
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		Question question = new Question(titre:"titre", content:"content", date: new Date(), user: user)
		Response reponse = new Response(content: "content", date: new Date(), user: user, question: question)
		
		service.create(reponse)
		assertEquals(Response.findAll().size(), 1)
	}
	
	
	@Test
	void update() {
		// Création
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		Question question = new Question(titre:"titre", content:"content", date:new Date(), user: user)
		Response reponse = new Response(content: "content", date: new Date(), user: user, question: question)
		service.create(reponse)
		// Modification
		String newContent = "newContent"
		reponse.content = newContent
		service.update(reponse)
		// Vérification
		Response rModif = Response.findById(reponse.id)
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
