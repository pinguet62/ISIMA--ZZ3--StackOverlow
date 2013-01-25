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
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Commentaire commentaire = new Commentaire(content: "content", date: new Date())
		commentaire.author = user
		commentaire.messageVotable = question
		commentaire.save()
		
		assertEquals(Commentaire.findAll().size(), 1)
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
		
		assertEquals(Commentaire.findAll().size(), 1)
	}
	
}
