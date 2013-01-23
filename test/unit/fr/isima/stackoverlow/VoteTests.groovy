package fr.isima.stackoverlow



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Vote)
class VoteTests{
	void testAddVote() {
		mockDomain(User)
		mockDomain(Question)
		User u1 = new User(name:'Julien', mail:'julienTheBeauGosseOf62@msn.com', password:'moimoi')
		u1.save()
		
		Question q = new Question(titre:"IE : de la merde, ou pire ?",
			content:"Est-ce que Internet Explorer est bien ?",
			date:new Date(),
			user: u1)
		
		
		def qq = q.save()
		assertNotNull(qq)
		def qBdd = Question.get(1)
		assertNotNull(qBdd)

		qBdd.increaseMark()
		qBdd.increaseMark()
		print qBdd.mark()
		
	}
}