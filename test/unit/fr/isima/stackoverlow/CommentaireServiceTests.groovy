package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(CommentaireService)
@Mock([User, Question, Response, Commentaire])
class CommentaireServiceTests {
	
	CommentaireService service = new CommentaireService()
	
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
		Response.where{}.deleteAll()
		Commentaire.where{}.deleteAll()
	}
	
	
	@Test
    void add() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password').save()
		
		// Question
        Question question = new Question(titre:"titre", content:"content", date:new Date(), user: user).save()
		Commentaire commentaire1 = new Commentaire(content:"content", date:new Date(), user: user, messageVotable: question).save()
		service.add(question, commentaire1)
		assertEquals(Commentaire.findAll().size(), 1)
		
		// Réponse
		Response reponse = new Response(content:"content", date:new Date(), user: user, question: question).save()
		Commentaire commentaire2 = new Commentaire(content:"content", date:new Date(), user: user, messageVotable: reponse).save()
		service.add(reponse, commentaire2)
		assertEquals(Commentaire.findAll().size(), 2)
    }
	
	
	@Test
	void disable() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password').save()
		Question question = new Question(titre:"titre", content:"content", date:new Date(), user: user).save()
		Commentaire commentaire = new Commentaire(content:"content", date:new Date(), user: user, messageVotable: question).save()
		service.add(question, commentaire)
		assertEquals(Commentaire.findAll().size(), 1)
		
		service.disable(commentaire)
		assertFalse(commentaire.display)
	}
	
	
	@Test
	void delete() {
		User user = new User(name:'name', mail:'adresse@mail.com', password:'password').save()
		Question question = new Question(titre:"titre", content:"content", date:new Date(), user: user).save()
		Commentaire commentaire = new Commentaire(content:"content", date:new Date(), user: user, messageVotable: question).save()
		service.add(question, commentaire)
		assertEquals(Commentaire.findAll().size(), 1)
		
		service.delete(commentaire)
		assertEquals(Commentaire.findAll().size(), 0)
	}
	
}
