package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(VoteService)
@Mock([User, Question, Response, Vote])
class VoteServiceTests {
	
	VoteService service = new VoteService()
	
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
		Response.where{}.deleteAll()
		Vote.where{}.deleteAll()
	}
	
	
	@Test
	void getMark_user() {
		User user1 = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user1.save()
		User user2 = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user2.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user1
		question.save()
		
		Vote vote1 = new Vote(mark: +1)
		vote1.user = user1
		vote1.messageVotable = question
		vote1.save()
		Vote vote2 = new Vote(mark: +1)
		vote2.user = user2
		vote2.messageVotable = question
		vote2.save()
		
		def note = service.getMark(user1)
		assertEquals(note, +2)
	}
	
	
	@Test
	void getMark_message() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Vote vote = new Vote(mark: -1)
		vote.user = user
		vote.messageVotable = question
		vote.save()
		
		def note = service.getMark(question)
		assertEquals(note, -1)
	}
	
	
	@Test
	void voteUp_new() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		service.voteUp(question, user)
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
	}
	
	
	@Test
	void voteUp_annulerNegatif() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Vote vote = new Vote(mark: -1)
		vote.user = user
		vote.messageVotable = question
		vote.save()
		
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
		service.voteUp(question, user)
		assertNull(Vote.findByUserAndMessageVotable(user, question))
	}
	
	
	@Test
	void voteUp_dejaVote() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Vote vote = new Vote(mark: +1)
		vote.user = user
		vote.messageVotable = question
		vote.save()
		
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
		service.voteUp(question, user)
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
	}
	
	
	@Test
	void voteDown_new() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		service.voteDown(question, user)
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
	}
	
	
	@Test
	void voteDown_annulerPositif() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Vote vote = new Vote(mark: +1)
		vote.user = user
		vote.messageVotable = question
		vote.save()
		
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
		service.voteDown(question, user)
		assertNull(Vote.findByUserAndMessageVotable(user, question))
	}
	
	
	@Test
	void voteDown_dejaVote() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		Vote vote = new Vote(mark: -1)
		vote.user = user
		vote.messageVotable = question
		vote.save()
		
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
		service.voteDown(question, user)
		assertNotNull(Vote.findByUserAndMessageVotable(user, question))
	}
	
}
