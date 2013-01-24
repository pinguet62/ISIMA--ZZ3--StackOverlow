package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

// TODO
@TestFor(QuestionService)
@Mock([User, Question, Vote])
class QuestionServiceTests {
	
	User u
	User u2
	Object obj
	Question q
	Boolean res
	
	
	@Before 
	public void setUp() {
		u = new User(name:'Julien', mail:'mail@mail.com', password:'moimoi')
		u2 = new User(name:'Pierre', mail:'mailmail@mail.com', password:'mm')
		u.save()
		u2.save()
		q = new Question(titre:"mytitle",
			content:"mycontent",
			date:new Date(),
			user: u)
		q.save()
	}
	
	
	@Test
	void testVoteUp() {
		MessageVotableService mServ = new MessageVotableService()
		res = mServ.voteUp(u, q)
		assertTrue(res)
		
		res = mServ.voteUp(u, q)
		assertFalse(res)
	}
	
	
	@Test
	void testGetMark()
	{
		int nbVote = -1
		MessageVotableService mServ = new MessageVotableService()
		
		nbVote= mServ.getMark(q)
		//assertEquals(nbVote, 0)
		print nbVote
		mServ.voteUp(u, q)
		nbVote= mServ.getMark(q)
		//assertEquals(nbVote, 1)
		print nbVote
		
		mServ.voteUp(u2, q)
		nbVote= mServ.getMark(q)
		//assertEquals(nbVote, 2)
		print nbVote
	}
	
}