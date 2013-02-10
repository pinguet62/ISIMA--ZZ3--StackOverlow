package fr.isima.stackoverlow

import grails.test.mixin.*
import org.junit.*

@TestFor(Question)
@Mock([User, Tag])
class QuestionTests {
	
	@Before
	void before() {
		User.where{}.deleteAll()
		Question.where{}.deleteAll()
		Tag.where{}.deleteAll()
	}
	
	
	@Test
	void user() {
		User userQ = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		userQ.save()
		assertEquals(User.list().size(), 1)
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = userQ
		question.save()
		assertEquals(Question.list().size(), 1)
		
		assertEquals(User.findById(userQ.id).messages.size(), 1)
	}
	
	
	@Test
	void tag() {
		User userQ = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		userQ.save()
		assertEquals(User.list().size(), 1)
		
		Tag tag = new Tag(name: "tag")
		tag.save()
		assertEquals(Tag.list().size(), 1)
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = userQ
		question.addToTags(tag)
		question.save()
		assertEquals(Question.list().size(), 1)
		
		assertEquals(Question.findById(question.id).tags.size(), 1)
	}
	
}
