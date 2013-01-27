import fr.isima.stackoverlow.Question
import fr.isima.stackoverlow.User

class BootStrap {

    def init = { servletContext ->
		User user1 = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user1.save()
		User user2 = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user2.save()
		
		Question question = new Question(title: "title", content: "content", date: new Date())
		question.author = user1
		question.save()
	}
	
    def destroy = {
    }
	
}
