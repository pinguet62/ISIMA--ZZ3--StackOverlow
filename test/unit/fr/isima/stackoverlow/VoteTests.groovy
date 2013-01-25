package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(Vote)
@Mock([User, Question, Response])
class VoteTests{
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
		Response.where{}.deleteAll()
		Vote.where{}.deleteAll()
	}
	
	
	@Test
	void question() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Vote vote = new Vote(mark: -1)
		vote.user = user
		vote.messageVotable = question
		vote.save()
		
		assertEquals(Vote.findAll().size(), 1)
	}
	
	
	@Test
	void response() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Response response = new Response(content: "content", date: new Date(), user: user, question: question)
		Vote vote = new Vote(mark: -1)
		vote.user = user
		vote.messageVotable = response
		vote.save()
		
		assertEquals(Vote.findAll().size(), 1)
	}
	
}