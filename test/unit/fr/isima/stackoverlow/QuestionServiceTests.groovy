package fr.isima.stackoverlow

import grails.test.mixin.*
import org.junit.*

@TestFor(QuestionService)
@Mock([User, Question,Tag])
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
		Tag tagQ1T2 = new Tag(name: "tagQ1T2")
			question.addToTags(tagQ1T2)
			tagQ1T2.save()
		service.create(question)
		assertEquals(Question.findAll().size(), 1)
	}
	
	
	@Test
	void update() {
		User user = new User(name:"userName", mail:"userAdresse@mail.com", password:"userPassword")
		user.save()
		
		Question question = new Question(title:"titre", content:"content", date: new Date())
		question.author = user
		Tag tagQ1T2 = new Tag(name: "tagQ1T2")
		question.addToTags(tagQ1T2)
		tagQ1T2.save()
		
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