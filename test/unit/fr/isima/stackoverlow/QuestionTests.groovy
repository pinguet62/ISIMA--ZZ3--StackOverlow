package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

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
	void question() {
		User user = new User(name:"userName", mail:"userAdresse@mail.com", password:"userPassword")
		user.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.save()
		
		assertEquals(Question.findAll().size(), 1)
	}
	
	
	@Test
	void tag() {
		User user = new User(name:"userName", mail:"userAdresse@mail.com", password:"userPassword")
		user.save()
		
		Tag tag = new Tag(name: "tag")
		tag.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user
		question.addToTags(tag)
		question.save()
		
		assertEquals(Question.findAll().size(), 1)
	}
	
}
