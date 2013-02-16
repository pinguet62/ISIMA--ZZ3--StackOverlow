import fr.isima.stackoverlow.Commentaire
import fr.isima.stackoverlow.Question
import fr.isima.stackoverlow.Response
import fr.isima.stackoverlow.Tag
import fr.isima.stackoverlow.User
import fr.isima.stackoverlow.Vote

class BootStrap {

	/**
	 * Code lunch when we lunch the application
	 * We fill the database with mock information in order to test our website
	 */
    def init = { servletContext ->
		// Questions + Tags multiple
		Tag tagMultiple = new Tag(name: "tagMultiple", description: "Ceci est un tag qui apparait dans plusieurs questions pour pouvoir apparaitre en premier dans la liste des tags les plus utilisés").save(failOnError: true)
		User userTagMultiple = new User(name: "userTagMultiple", mail: "userTagMultipleAdresse@mail.com", password: "userTagMultiplePassword").save(failOnError: true)
		for (int i=0 ; i<5 ; i++) {
			Question qTagMultiple = new Question(title: "titleQTagMultiple"+i, content: "contentqTagMultiple"+i, date: new Date())
			qTagMultiple.author = userTagMultiple
			qTagMultiple.addToTags(tagMultiple)
			qTagMultiple.save(failOnError: true)
		}
		
		// Administrateur
		User admin1 = new User(name: "adminustrator1Name", mail: "adminustrator1Adresse@mail.com", password: "adminustrator1Password", admin: true)
		admin1.save(failOnError: true)
		User admin2 = new User(name: "adminustrator2Name", mail: "adminustrator2Adresse@mail.com", password: "adminustrator2Password", avatarUrl: "/avatar/01.png", admin: true)
		admin2.save(failOnError: true)
		// Question Q1
		User userQ1 = new User(name: "userQ1Name", mail: "userQ1Adresse@mail.com", password: "userQ1Password", avatarUrl: "/avatar/01.png")
		userQ1.save(failOnError: true)
		Question questionQ1 = new Question(title: "Editablegrids HTML", content: "am having a problem with editable grid from mySql DB. It loads the data well but when I need to edit they pick only data from the first row only. it doesn't load the other cell data on the update text boxes.Any help will be appreciated.am useing this http://www.editablegrid.net/en modules", date: new Date())
		questionQ1.author = userQ1
				// Tag Q1T1
				Tag tagQ1T1 = new Tag(name: "mysql")
				questionQ1.addToTags(tagQ1T1)
				tagQ1T1.save(failOnError: true)
				// Tag Q1T2
				Tag tagQ1T2 = new Tag(name: "ajax")
				questionQ1.addToTags(tagQ1T2)
				tagQ1T2.save(failOnError: true)
			questionQ1.save(failOnError: true)
				// Commentaire Q1C1
				User userQ1C1 = new User(name: "userQ1C1Name", mail: "userQ1C1Adresse@mail.com", password: "userQ1C1Password", avatarUrl: "/avatar/02.png")
				userQ1C1.save(failOnError: true)
				Commentaire commentaireQ1C1 = new Commentaire(content: "Use an AsyncTask. Its specially designed for this kinda stuff", date: new Date())
				commentaireQ1C1.author = userQ1C1
				commentaireQ1C1.messageVotable = questionQ1
				questionQ1.addToCommentaires(commentaireQ1C1)
				commentaireQ1C1.save(failOnError: true)
				// Commentaire Q1C2
				User userQ1C2 = new User(name: "userQ1C2Name", mail: "userQ1C2Adresse@mail.com", password: "userQ1C2Password", avatarUrl: "/avatar/03.png")
				userQ1C2.save(failOnError: true)
				Commentaire commentaireQ1C2 = new Commentaire(content: "contentQ1C2", date: new Date())
				commentaireQ1C2.author = userQ1C2
				commentaireQ1C2.messageVotable = questionQ1
				questionQ1.addToCommentaires(commentaireQ1C2)
				commentaireQ1C2.save(failOnError: true)
			// Reponse Q1R1
			User userQ1R1 = new User(name: "userQ1R1Name", mail: "userQ1R1Adresse@mail.com", password: "userQ1R1Password", avatarUrl: "/avatar/04.jpg")
			userQ1R1.save(failOnError: true)
			Response responseQ1R1 = new Response(content: "To get the result that you want, you will need to use the PIVOT function. If all of your values (title) are known ahead of time, then you can hard-code a static query:blablabla", date: new Date())
			responseQ1R1.author = userQ1R1
			responseQ1R1.question = questionQ1
			questionQ1.addToResponses(responseQ1R1)
			responseQ1R1.save(failOnError: true)
				// Commentaire Q1R1C1
				User userQ1R1C1 = new User(name: "userQ1R1C1Name", mail: "userQ1R1C1Adresse@mail.com", password: "userQ1R1C1Password", avatarUrl: "/avatar/05.jpg")
				userQ1R1C1.save(failOnError: true)
				Commentaire commentaireQ1R1C1 = new Commentaire(content: "thanks a lot for you perfect answer. If you dont mind I need to have two more options: 1. how to request the result by [ReportID] 2. how to sort the headers by a column called [SortOrder] in [ReportItems]? ", date: new Date())
				commentaireQ1R1C1.author = userQ1R1C1
				commentaireQ1R1C1.messageVotable = responseQ1R1
				responseQ1R1.addToCommentaires(commentaireQ1R1C1)
				commentaireQ1R1C1.save(failOnError: true)
				// Commentaire Q1R1C2
				User userQ1R1C2 = new User(name: "userQ1R1C2Name", mail: "userQ1R1C2Adresse@mail.com", password: "userQ1R1C2Password", avatarUrl: "/avatar/06.jpg")
				userQ1R1C2.save(failOnError: true)
				Commentaire commentaireQ1R1C2 = new Commentaire(content: "@Kardo can you edit the sql fiddle with the additional data needed? When you edit it, post the link here. Or create a new question with the additional details. ", date: new Date())
				commentaireQ1R1C2.author = userQ1R1C2
				commentaireQ1R1C2.messageVotable = responseQ1R1
				responseQ1R1.addToCommentaires(commentaireQ1R1C2)
				commentaireQ1R1C2.save(failOnError: true)
				// Vote Q1R1V1
				Vote voteQ1R1V1 = new Vote(mark: +1)
				voteQ1R1V1.user = userQ1R1C1
				voteQ1R1V1.messageVotable = responseQ1R1
				voteQ1R1V1.save(failOnError: true)
				// Vote Q1R1V2
				Vote voteQ1R1V2 = new Vote(mark: +1)
				voteQ1R1V2.user = userQ1R1C2
				voteQ1R1V2.messageVotable = responseQ1R1
				voteQ1R1V2.save(failOnError: true)
			// Reponse Q1R2
			User userQ1R2 = new User(name: "userQ1R2Name", mail: "userQ1R2Adresse@mail.com", password: "userQ1R2Password", avatarUrl: "/avatar/07.jpg")
			userQ1R2.save(failOnError: true)
			Response responseQ1R2 = new Response(content: "Well, there was an article by Phil Factor (On simple-talk.com, I think), that argued that the CASE solutions performed better then the PIVOT one. Anyway, it's your call.", date: new Date())
			responseQ1R2.author = userQ1R2
			responseQ1R2.question = questionQ1
			questionQ1.addToResponses(responseQ1R2)
			responseQ1R2.save(failOnError: true)
				// Commentaire Q1R2C1
				User userQ1R2C1 = new User(name: "userQ1R2C1Name", mail: "userQ1R2C1Adresse@mail.com", password: "userQ1R2C1Password", avatarUrl: "/avatar/08.jpg")
				userQ1R2C1.save(failOnError: true)
				Commentaire commentaireQ1R2C1 = new Commentaire(content: "Hi @Daniel, Your answer is correct too. Now I'm confused which one is a better solution to use? Many Thanks again :)", date: new Date())
				commentaireQ1R2C1.author = userQ1R2C1
				commentaireQ1R2C1.messageVotable = responseQ1R2
				responseQ1R2.addToCommentaires(commentaireQ1R2C1)
				commentaireQ1R2C1.save(failOnError: true)
				// Commentaire Q1R2C2
				User userQ1R2C2 = new User(name: "userQ1R2C2Name", mail: "userQ1R2C2Adresse@mail.com", password: "userQ1R2C2Password", avatarUrl: "/avatar/09.jpg")
				userQ1R2C2.save(failOnError: true)
				Commentaire commentaireQ1R2C2 = new Commentaire(content: "@Kardo see my edit with how you can use the SortOrder to keep the columns in the correct order. ", date: new Date())
				commentaireQ1R2C2.author = userQ1R2C2
				commentaireQ1R2C2.messageVotable = responseQ1R2
				responseQ1R2.addToCommentaires(commentaireQ1R2C2)
				commentaireQ1R2C2.save(failOnError: true)
				// Vote Q1R2V1
				Vote voteQ1R2V1 = new Vote(mark: +1)
				voteQ1R2V1.user = userQ1R2C1
				voteQ1R2V1.messageVotable = responseQ1R2
				voteQ1R2V1.save(failOnError: true)
				// Vote Q1R2V2
				Vote voteQ1R2V2 = new Vote(mark: -1)
				voteQ1R2V2.user = userQ1R2C2
				voteQ1R2V2.messageVotable = responseQ1R2
				voteQ1R2V2.save(failOnError: true)
			// Vote Q1V1
			Vote voteQ1V1 = new Vote(mark: -1)
			voteQ1V1.user = userQ1R1
			voteQ1V1.messageVotable = questionQ1
			voteQ1V1.save(failOnError: true)
			// Vote Q1V2
			Vote voteQ1V2 = new Vote(mark: -1)
			voteQ1V2.user = userQ1R2
			voteQ1V2.messageVotable = questionQ1
			voteQ1V2.save(failOnError: true)
		// Question Q2
		User userQ2 = new User(name: "userQ2Name", mail: "userQ2Adresse@mail.com", password: "userQ2Password")
		userQ2.save(failOnError: true)
		Question questionQ2 = new Question(title: "TSQL creating a dynamic report from two tables.", content: "Imagine a scenario in which I want to get a dynamic report from [FormValues] as data, based on [Title] column of [ReportItems] as header. I'm really confused how to do it and tried many ways, but none of them work fine. I should be able to give a procedure a [ReportID] and get the result. [FormID] and [FieldID] are relational keys in between two tables.Any kind help would be highly appreciated.", date: new Date())
		questionQ2.author = userQ2
			// Tag Q2T1
			Tag tagQ2T1 = new Tag(name: "sql")
			questionQ2.addToTags(tagQ2T1)
			tagQ2T1.save(failOnError: true)
			// Tag Q2T2
			Tag tagQ2T2 = new Tag(name: "oracle")
			questionQ2.addToTags(tagQ2T2)
			tagQ2T2.save(failOnError: true)
		questionQ2.save(failOnError: true)
				// Commentaire Q2C1
				User userQ2C1 = new User(name: "userQ2C1Name", mail: "userQ2C1Adresse@mail.com", password: "userQ2C1Password", avatarUrl: "/avatar/09.jpg")
				userQ2C1.save(failOnError: true)
				Commentaire commentaireQ2C1 = new Commentaire(content: "You can stretch the texture across the surface by interpolating from 0 to 1:", date: new Date())
				commentaireQ2C1.author = userQ2C1
				commentaireQ2C1.messageVotable = questionQ2
				questionQ2.addToCommentaires(commentaireQ2C1)
				commentaireQ2C1.save(failOnError: true)
				// Commentaire Q2C2
				User userQ2C2 = new User(name: "userQ2C2Name",  mail: "userQ2C2Adresse@mail.com", password: "userQ2C2Password", avatarUrl: "/avatar/10.jpg")
				userQ2C2.save(failOnError: true)
				Commentaire commentaireQ2C2 = new Commentaire(content: "Your guess is good.You are using a JTATransactionFactory, so the transaction is demarcated by JTA (i.e by the container).The method you are using to save the Request (here I presume it is defined in an EJB ) needs to be annotated with a transactional annotation: @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW), so when the method ends, the transaction gets committed.", date: new Date())
				commentaireQ2C2.author = userQ2C2
				commentaireQ2C2.messageVotable = questionQ2
				questionQ2.addToCommentaires(commentaireQ2C2)
				commentaireQ2C2.save(failOnError: true)
			// Reponse Q2R1
			User userQ2R1 = new User(name: "userQ2R1Name",  mail: "userQ2R1Adresse@mail.com", password: "userQ2R1Password", avatarUrl: "/avatar/11.jpg")
			userQ2R1.save(failOnError: true)
			Response responseQ2R1 = new Response(content: "Hmmm, this looks good and is probably close to the mark but the method isn't in an EJB. I tried Seam's @Transactional attribute but this didn't make any difference... any suggestions?", date: new Date())
			responseQ2R1.author = userQ2R1
			responseQ2R1.question = questionQ2
			questionQ2.addToResponses(responseQ2R1)
			responseQ2R1.save(failOnError: true)
				// Commentaire Q2R1C1
				User userQ2R1C1 = new User(name: "userQ2R1C1Name", mail: "userQ2R1C1Adresse@mail.com", password: "userQ2R1C1Password", avatarUrl: "/avatar/02.png")
				userQ2R1C1.save(failOnError: true)
				Commentaire commentaireQ2R1C1 = new Commentaire(content: "That might be an option. securing workbook is not an option as I want to provide an option to the user to import some sheets, so when the do Copy or Move from old version of the file, it would not add new sheets, instead it will update the existing sheet in the file with data from copied/moved data.", date: new Date())
				commentaireQ2R1C1.author = userQ2R1C1
				commentaireQ2R1C1.messageVotable = responseQ2R1
				responseQ2R1.addToCommentaires(commentaireQ2R1C1)
				commentaireQ2R1C1.save(failOnError: true)
				// Commentaire Q2R1C2
				User userQ2R1C2 = new User(name: "userQ2R1C2Name", mail: "userQ2R1C2Adresse@mail.com", password: "userQ2R1C2Password")
				userQ2R1C2.save(failOnError: true)
				Commentaire commentaireQ2R1C2 = new Commentaire(content: "\"SheetActivate event will fire under all of those circumstances\" It does not.. when multiple sheets are copied over it fires only once for the first sheet.. Maintaining a separate sheets collection is a pain, So as of now I have chosen to disable Move/Copy sheets option from Ply menu, so user can not move sheets from one version of the file to other. Also I handled New Sheet to block new sheets being added. So as of now I am done with that tool. But hope to see more robust events modal in next version of Excel than one Joel designed long back. ", date: new Date())
				commentaireQ2R1C2.author = userQ2R1C2
				commentaireQ2R1C2.messageVotable = responseQ2R1
				responseQ2R1.addToCommentaires(commentaireQ2R1C2)
				commentaireQ2R1C2.save(failOnError: true)
			// Reponse Q2R2
			User userQ2R2 = new User(name: "userQ2R2Name", mail: "userQ2R2Adresse@mail.com", password: "userQ2R2Password", avatarUrl: "http://icons.iconarchive.com/icons/deleket/sleek-xp-software/256/Yahoo-Messenger-icon.png")
			userQ2R2.save(failOnError: true)
			Response responseQ2R2 = new Response(content: "When a sheet is copied, its name will always end with \"(2)\", or at least \")\". You could check on that like this", date: new Date())
			responseQ2R2.author = userQ2R2
			responseQ2R2.question = questionQ2
			questionQ2.addToResponses(responseQ2R2)
			responseQ2R2.save(failOnError: true)
				// Commentaire Q2R2C1
				User userQ2R2C1 = new User(name: "userQ2R2C1Name", mail: "userQ2R2C1Adresse@mail.com", password: "userQ2R2C1Password")
				userQ2R2C1.save(failOnError: true)
				Commentaire commentaireQ2R2C1 = new Commentaire(content: "I would use the Amazon Product Advertising API ItemSearch API (see doc: http://docs.amazonwebservices.com/AWSECommerceService/2010-11-01/DG/ItemSearch.html)When forming your request, you will need to pass a number of parameters such as \"Title\", \"SearchIndex\" (\"Books\" in your case) and additional mandatory parameters (Note that you can try adding more request parameters, such as \"Author\" or \"Keywords\" to fine tune your query).", date: new Date())
				commentaireQ2R2C1.author = userQ2R2C1
				commentaireQ2R2C1.messageVotable = responseQ2R2
				responseQ2R2.addToCommentaires(commentaireQ2R2C1)
				commentaireQ2R2C1.save(failOnError: true)
				// Commentaire Q2R2C2
				User userQ2R2C2 = new User(name: "userQ2R2C2Name", mail: "userQ2R2C2Adresse@mail.com", password: "userQ2R2C2Password", avatarUrl: "/avatar/06.jpg")
				userQ2R2C2.save(failOnError: true)
				Commentaire commentaireQ2R2C2 = new Commentaire(content: "webwiz, did you ever find a solution to getting a book's ASIN programmatically, given its title? ", date: new Date())
				commentaireQ2R2C2.author = userQ2R2C2
				commentaireQ2R2C2.messageVotable = responseQ2R2
				responseQ2R2.addToCommentaires(commentaireQ2R2C2)
				commentaireQ2R2C2.save(failOnError: true)
			// Vote Q2V1
			Vote voteQ2V1 = new Vote(mark: -1)
			voteQ2V1.user = userQ2R1
			voteQ2V1.messageVotable = questionQ2
			voteQ2V1.save(failOnError: true)
		// Question Q3
		User userQ3 = new User(name: "Paul Machon", mail: "paulMach@outlook.com", password: "azertyuiop")
		userQ3.save(failOnError: true)
		Question questionQ3 = new Question(title: "Probleme compilation", content: "Bonjour, grand programmeur en C, je ne parvien pas a compiler mon programme: <br> l'erreur est la suivante: missing function 'Main' in 'monAppli.c.'<br> quelqu'un peut-il m'aider?", date: new Date())
		questionQ3.author = userQ3
			// Tag Q3T1
			Tag tagQ3T1 = new Tag(name: "C++", description: "C++ est le meilleur langage ! Le langage orienté objet le plus rapide. La programmation bas-niveau c'est mieux car on sait comment ça fonctionne !")
			questionQ3.addToTags(tagQ3T1)
			tagQ3T1.save(failOnError: true)
		questionQ3.save(failOnError: true)
		// Question Q4
		User userQ4 = new User(name: "Jean63", mail: "jean-retyui@outlook.com", password: "uiopaaazaze")
		userQ4.save(failOnError: true)
		Question questionQ4 = new Question(title: "Qu'est ce qu'un bean?", content: "Bonjour.\n\nJ'ai eu un cours sur les JavaBeans. Je n'ai absuloment rien compris, car ce qui se passe par la fenetre etait bien plus interessant !!!\nQuelqu'un peut-il m'expliquer rapidement? vite car j'ai piscine dans 15 minute.\n\n>Merci, et bisous", date: new Date())
		questionQ4.author = userQ4
			// Tag Q4T1
			Tag tagQ4T1 = new Tag(name: "JAVA", description: "Java est Super mais les gens ne le savent pas encore! Très portable car tourne partous grace à la JVM")
			questionQ4.addToTags(tagQ4T1)
			tagQ4T1.save(failOnError: true)
		questionQ4.save(failOnError: true)
		for (int i=5 ; i<35 ; i++) {
			// Question Qi
			User userQi = new User(name: "userQ"+i+"Name", mail: "userQ"+i+"Adresse@mail.com", password: "userQ"+i+"Password")
			userQi.save(failOnError: true)
			Question questionQi = new Question(title: "titleQ"+i, content: "contentQ"+i, date: new Date())
			questionQi.author = userQi
			questionQi.save(failOnError: true)
				// Tag QiT1
				Tag tagQiT1 = new Tag(name: "tagQ"+i+"T1")
				questionQi.addToTags(tagQiT1)
				tagQiT1.save(failOnError: true)
		}
		
		// Tags
		for (int i=5 ; i<50 ; i++)
			Tag tag = new Tag(name: "Tag"+i, description: "petite description de "+i+"qui n'en est pas une, mais c'est juste pour afficher plein de choses sur la page pour vérifier que cela ne bug pas trop mdr.").save(failOnError: true)
		
		Vote v = new Vote()
		v.messageVotable = questionQ4
		v.user = userQ3
		v.mark= +1
		v.save(failOnError: true)
		
		Vote v2 = new Vote()
		v2.messageVotable = questionQ4
		v2.user = userQ1
		v2.mark= +1
		v2.save(failOnError: true)
		
		
		Vote v3 = new Vote()
		v3.messageVotable = questionQ3
		v3.user = userQ1
		v3.mark= -1
		v3.save(failOnError: true)

		
		println "BDD initiate :"
		println "- " + User.count + " users"
		println "- " + Question.count + " questions"
		println "- " + Response.count + " reponses"
		println "- " + Commentaire.count + " comments"
		println "- " + Vote.count + " votes"
		println "- " + Tag.count + " tags"
	}
	
	
    def destroy = {
    }
	
}
