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
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		Question question = new Question(titre:"titre", content:"content", date:new Date(), user: user)
		
		service.create(question)
		assertEquals(Question.findAll().size(), 1)
	}
	
	
	@Test
	void update() {
		// Création
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password')
		Question question = new Question(titre:"titre", content:"content", date:new Date(), user: user)
		service.create(question)
		// Modification
		String newTitre = "newTitre"
		String newContent = "newContent"
		question.titre = newTitre
		question.content = newContent
		service.update(question)
		// Vérification
		Question qModif = Question.findById(question.id)
		assertEquals(qModif.titre, newTitre)
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