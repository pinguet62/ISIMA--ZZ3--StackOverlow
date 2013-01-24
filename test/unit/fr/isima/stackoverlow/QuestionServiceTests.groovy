package fr.isima.stackoverlow

import org.junit.Test

// TODO
@TestFor(QuestionService)
@Mock([Question, Message])
class QuestionServiceTests {
	
	@Test
	void testVoteUp() {
		Object obj;
		Boolean res;
		
		User u = new User(name:'Julien', mail:'julienTheBeauGosseOf62@msn.com', password:'moimoi')
		obj = u.save()
		assertNotNull(obj)
		
		Question q = new Question(titre:"IE : de la merde, ou pire ?",
			content:"Est-ce que Internet Explorer est bien ?",
			date:new Date(),
			user: u)
		obj = q.save()
		assertNotNull(obj)
		
		QuestionService mServ = new MessageVotableService()
		res = mServ.voteUp(u, q)
		assertTrue(res)
	}
	
}