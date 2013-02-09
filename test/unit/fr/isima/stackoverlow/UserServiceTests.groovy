package fr.isima.stackoverlow

import org.junit.Before
import org.junit.Test

@TestFor(UserService)
@Mock([User, Commentaire, Question, Response, Vote, Message])
class UserServiceTests {
	
	UserService service = new UserService()
	
	
	@Before
	void before() {
		User.where{}.deleteAll()
	}
	
	
	@Test
	void exist() {
		User user1 = new User(name: "user1Name", mail: "user1Adresse@mail.com", password: "user1Password")
		assertFalse(service.exists(user1))
		
		User user2 = new User(name: "user2Name", mail: "user2Adresse@mail.com", password: "user2Password")
		user2.save()
		assertTrue(service.exists(user2))
	}
	
	
	@Test
    void disponible() {
        User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		assertFalse(service.disponible(user.getName()))
		assertTrue(service.disponible("inconnu"))
    }
	
	
	@Test
	void create() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		assertTrue(service.disponible(user.getName()))
		
		service.create(user);
		assertFalse(service.disponible(user.getName()))
	}
	
	
	@Test
	void delete() {
		User user = new User(name: "userName", mail: "userAdresse@mail.com", password: "userPassword")
		user.save()
		assertTrue(service.exists(user))
		
		service.delete(user);
		assertFalse(service.exists(user))
	}
	
	
	@Test
	void getAdmin()
	{
		User user1 = new User(name: "userName1", admin: true,mail: "userAdresse@mail.com", password: "userPassword")
		user1.save()
		User user2 = new User(name: "userName2", mail: "userAdresse@mail.com", password: "userPassword")
		user2.save()
		
		List<User> lst = service.getAdmin()
		assertEquals(lst.size(),1);
		assertTrue(lst.get(0).admin);
	}
	
	
	@Test
	void getAll()
	{
		User user1 = new User(name: "userName1", admin: true,mail: "userAdresse@mail.com", password: "userPassword")
		user1 = user1.save()
		User user2 = new User(name: "userNadsme2", mail: "userAdressssssse@mail.com", password: "userPassword")
		user2 = user2.save()
		
		List<User> lst =  service.getAll()
		assertEquals(lst.size(),2);
		
	}
	
	@Test
	void getUserWithmark()
	{
		// Question Q3
		User userQ3 = new User(name: "Paul Machon", mail: "paulMach@outlook.com", password: "azertyuiop")
		userQ3.save()
		Question questionQ3 = new Question(title: "Probleme compilation", content: "Bonjour, grand programmeur en C, je ne parvien pas a compiler mon programme: <br> l'erreur est la suivante: missing function 'Main' in 'monAppli.c.'<br> quelqu'un peut-il m'aider?", date: new Date())
		questionQ3.author = userQ3
		questionQ3.save()

		// Question Q4
		User userQ4 = new User(name: "Jean63", mail: "jean-retyui@outlook.com", password: "uiopaaazaze")
		userQ4.save()
		Question questionQ4 = new Question(title: "Qu'est ce qu'un bean?", content: "Bonjour.\n\nJ'ai eu un cours sur les JavaBeans. Je n'ai absuloment rien compris, car ce qui se passe par la fenetre etait bien plus interessant !!!\nQuelqu'un peut-il m'expliquer rapidement? vite car j'ai piscine dans 15 minute.\n\n>Merci, et bisous", date: new Date())
		questionQ4.author = userQ4
		questionQ4.save()
		Vote v = new Vote()
		v.messageVotable = questionQ4
		v.user = userQ3
		v.mark= -1
		v.save()
		
		Vote v2 = new Vote()
		v2.messageVotable = questionQ3
		v2.user = userQ4
		v2.mark= +1
		v2.save()

		List<User> lst  = service.getUserWithMark()
		assertEquals(lst.size(),2);
	}
	
	@Test
	void getUserActivity()
	{
		// Question Q3
		User userQ3 = new User(name: "Paul Machon", mail: "paulMach@outlook.com", password: "azertyuiop")
		userQ3.save()
		User userQ4 = new User(name: "Jean63", mail: "jean-retyui@outlook.com", password: "uiopaaazaze")
		userQ4 = userQ4.save()
		Date d = new Date()
		Question questionQ3 = new Question(title: "Probleme compilation", content: "Bonjour, grand programmeur en C, je ne parvien pas a compiler mon programme: <br> l'erreur est la suivante: missing function 'Main' in 'monAppli.c.'<br> quelqu'un peut-il m'aider?", date: d)
		questionQ3.author = userQ3
		questionQ3 = questionQ3.save()
		
		
		Commentaire commentaireQ2C1 = new Commentaire(content: "fggfdgfdgdfg", date: d)
		commentaireQ2C1.author = userQ4
		commentaireQ2C1.messageVotable = questionQ3
		questionQ3.addToCommentaires(commentaireQ2C1)
		commentaireQ2C1 = commentaireQ2C1.save()
		
		Map<Date,List<Message>> actUQ3 = service.getUserActivity(userQ3)
		Map<Date,List<Message>> actUQ4 = service.getUserActivity(userQ4)
		
		assertEquals(actUQ3.get(d).size(),1);
		assertEquals(actUQ4.get(d).size(),1);
		
		assertEquals(actUQ3.get(d).get(0).title,questionQ3.title);
		assertEquals(actUQ4.get(d).get(0).content,commentaireQ2C1.content);
	}
	
	
}
