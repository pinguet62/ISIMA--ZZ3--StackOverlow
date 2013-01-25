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
    void add_Question() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Commentaire commentaire = new Commentaire(content:"content", date: new Date())
		commentaire.author = user
		commentaire.messageVotable = question
		
		service.add(question, commentaire)
		assertEquals(Commentaire.list().size(), 1)
	}
	
	
	@Test
	void add_Response() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Response response = new Response(content: "content", date: new Date())
		response.author = user
		response.question = question
		response.save()
		
		Commentaire commentaire = new Commentaire(content: "content", date: new Date())
		commentaire.author = user
		commentaire.messageVotable = response
		
		service.add(response, commentaire)
		assertEquals(Commentaire.list().size(), 1)
    }
	
	
	@Test
	void update() {
		// TODO
	}
	
	
	@Test
	void disable() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(titre: "titre", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Commentaire commentaire = new Commentaire(content: "content", date: new Date())
		commentaire.author = user
		commentaire.messageVotable = question
		
		service.add(question, commentaire)
		assertEquals(Commentaire.list().size(), 1)
		
		service.disable(commentaire)
		assertFalse(commentaire.display)
	}
	
	
	@Test
	void delete() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(titre: "titre", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Commentaire commentaire = new Commentaire(content: "content", date: new Date())
		commentaire.author = user
		commentaire.messageVotable = question
		
		service.add(question, commentaire)
		assertEquals(Commentaire.list().size(), 1)
		
		service.delete(commentaire)
		assertEquals(Commentaire.list().size(), 0)
	}
	
}
