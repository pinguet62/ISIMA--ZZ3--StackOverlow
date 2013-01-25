package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(QuestionService)
@Mock([User, Question])
class QuestionServiceTests {
	
	QuestionService service = new QuestionService()
	
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
	}
	
	
	@Test
	void create() {
		User user = new User(name:"userName", mail:"userAdresse@mail.com", password:"userPassword")
		user.save()
		
		Question question = new Question(title:"titre", content:"content", date: new Date())
		question.author = user
		
		service.create(question)
		assertEquals(Question.findAll().size(), 1)
	}
	
	
	@Test
	void update() {
		User user = new User(name:"userName", mail:"userAdresse@mail.com", password:"userPassword")
		user.save()
		
		Question question = new Question(title:"titre", content:"content", date: new Date())
		question.author = user
		
		service.create(question)
		
		String newTitle = "newTitle"
		String newContent = "newContent"
		question.title = newTitle
		question.content = newContent
		service.update(question)
		
		Question qModif = Question.findById(question.id)
		assertEquals(qModif.title, newTitle)
		assertEquals(qModif.content, newContent)
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