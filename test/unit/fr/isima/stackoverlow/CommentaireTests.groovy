package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(Commentaire)
@Mock([User, Question, Response])
class CommentaireTests {
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
		Response.where{}.deleteAll()
		Commentaire.where{}.deleteAll()
	}
	
	
	@Test
	void question() {
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
		
		// Commentaire
		// - utilisateur
		User userC = new User(name:"userCName", mail:"userCAdresse@mail.com", password:"userCPassword")
		userC.save()
		assertEquals(User.list().size(), 2)
		assertNotNull(User.findById(userC.id))
		// - commentaire
		Commentaire commentaire = new Commentaire(content: "contentC", date: new Date())
		commentaire.author = userC
		commentaire.messageVotable = question
		commentaire.save()
		assertEquals(Commentaire.list().size(), 1)
		assertNotNull(Commentaire.findById(commentaire.id))
	}
	
	
	@Test
	void response() {
		User user = new User(name:"userName", mail:"userAdresse@mail.com", password:"userPassword")
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
		commentaire.save()
		
		assertEquals(Commentaire.list().size(), 1)
	}
	
}
