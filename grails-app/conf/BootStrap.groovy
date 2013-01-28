import fr.isima.stackoverlow.Commentaire
import fr.isima.stackoverlow.Question
import fr.isima.stackoverlow.Response
import fr.isima.stackoverlow.Tag
import fr.isima.stackoverlow.User

class BootStrap {

	/**
	 * Code exécuté lors du lancement de l'application
	 * On y rempli la BDD avec des données permettants de tester l'application
	 */
    def init = { servletContext ->
		
		// Question Q1
		User userQ1 = new User(name: "userQ1Name", mail: "userQ1Adresse@mail.com", password: "userQ1Password")
		userQ1.save()
		Question questionQ1 = new Question(title: "titleQ1", content: "contentQ1", date: new Date())
		questionQ1.author = userQ1
		questionQ1.save()
				// Tag Q1T1
				Tag tagQ1T1 = new Tag(name: "tagQ1T1")
				questionQ1.addToTags(tagQ1T1)
				tagQ1T1.save()
				// Tag Q1T2
				Tag tagQ1T2 = new Tag(name: "tagQ1T2")
				questionQ1.addToTags(tagQ1T2)
				tagQ1T2.save()
				// Commentaire Q1C1
				User userQ1C1 = new User(name: "userQ1C1Name", mail: "userQ1C1Adresse@mail.com", password: "userQ1C1Password")
				userQ1C1.save()
				Commentaire commentaireQ1C1 = new Commentaire(content: "contentQ1C1", date: new Date())
				commentaireQ1C1.author = userQ1C1
				commentaireQ1C1.messageVotable = questionQ1
				questionQ1.addToCommentaires(commentaireQ1C1)
				commentaireQ1C1.save()
				// Commentaire Q1C2
				User userQ1C2 = new User(name: "userQ1C2Name", mail: "userQ1C2Adresse@mail.com", password: "userQ1C2Password")
				userQ1C2.save()
				Commentaire commentaireQ1C2 = new Commentaire(content: "contentQ1C2", date: new Date())
				commentaireQ1C2.author = userQ1C2
				commentaireQ1C2.messageVotable = questionQ1
				questionQ1.addToCommentaires(commentaireQ1C2)
				commentaireQ1C2.save()
			// Reponse Q1R1
			User userQ1R1 = new User(name: "userQ1R1Name", mail: "userQ1R1Adresse@mail.com", password: "userQ1R1Password")
			userQ1R1.save()
			Response responseQ1R1 = new Response(content: "contentQ1R1", date: new Date())
			responseQ1R1.author = userQ1R1
			responseQ1R1.question = questionQ1
			questionQ1.addToResponses(responseQ1R1)
			responseQ1R1.save()
				// Commentaire Q1R1C1
				User userQ1R1C1 = new User(name: "userQ1R1C1Name", mail: "userQ1R1C1Adresse@mail.com", password: "userQ1R1C1Password")
				userQ1R1C1.save()
				Commentaire commentaireQ1R1C1 = new Commentaire(content: "contentQ1R1C1", date: new Date())
				commentaireQ1R1C1.author = userQ1R1C1
				commentaireQ1R1C1.messageVotable = responseQ1R1
				responseQ1R1.addToCommentaires(commentaireQ1R1C1)
				commentaireQ1R1C1.save()
				// Commentaire Q1R1C2
				User userQ1R1C2 = new User(name: "userQ1R1C2Name", mail: "userQ1R1C2Adresse@mail.com", password: "userQ1R1C2Password")
				userQ1R1C2.save()
				Commentaire commentaireQ1R1C2 = new Commentaire(content: "contentQ1R1C2", date: new Date())
				commentaireQ1R1C2.author = userQ1R1C2
				commentaireQ1R1C2.messageVotable = responseQ1R1
				responseQ1R1.addToCommentaires(commentaireQ1R1C2)
				commentaireQ1R1C2.save()
			// Reponse Q1R2
			User userQ1R2 = new User(name: "userQ1R2Name", mail: "userQ1R2Adresse@mail.com", password: "userQ1R2Password")
			userQ1R2.save()
			Response responseQ1R2 = new Response(content: "contentQ1R2", date: new Date())
			responseQ1R2.author = userQ1R2
			responseQ1R2.question = questionQ1
			questionQ1.addToResponses(responseQ1R2)
			responseQ1R2.save()
				// Commentaire Q1R2C1
				User userQ1R2C1 = new User(name: "userQ1R2C1Name", mail: "userQ1R2C1Adresse@mail.com", password: "userQ1R2C1Password")
				userQ1R2C1.save()
				Commentaire commentaireQ1R2C1 = new Commentaire(content: "contentQ1R2C1", date: new Date())
				commentaireQ1R2C1.author = userQ1R2C1
				commentaireQ1R2C1.messageVotable = responseQ1R2
				responseQ1R2.addToCommentaires(commentaireQ1R2C1)
				commentaireQ1R2C1.save()
				// Commentaire Q1R2C2
				User userQ1R2C2 = new User(name: "userQ1R2C2Name", mail: "userQ1R2C2Adresse@mail.com", password: "userQ1R2C2Password")
				userQ1R2C2.save()
				Commentaire commentaireQ1R2C2 = new Commentaire(content: "contentQ1R2C2", date: new Date())
				commentaireQ1R2C2.author = userQ1R2C2
				commentaireQ1R2C2.messageVotable = responseQ1R2
				responseQ1R2.addToCommentaires(commentaireQ1R2C2)
				commentaireQ1R2C2.save()
		
		// Question Q2
		User userQ2 = new User(name: "userQ2Name", mail: "userQ2Adresse@mail.com", password: "userQ2Password")
		userQ2.save()
		Question questionQ2 = new Question(title: "titleQ2", content: "contentQ2", date: new Date())
		questionQ2.author = userQ2
		questionQ2.save()
				// Tag Q2T1
				Tag tagQ2T1 = new Tag(name: "tagQ2T1")
				questionQ2.addToTags(tagQ2T1)
				tagQ2T1.save()
				// Tag Q2T2
				Tag tagQ2T2 = new Tag(name: "tagQ2T2")
				questionQ2.addToTags(tagQ2T2)
				tagQ2T2.save()
				// Commentaire Q2C1
				User userQ2C1 = new User(name: "userQ2C1Name", mail: "userQ2C1Adresse@mail.com", password: "userQ2C1Password")
				userQ2C1.save()
				Commentaire commentaireQ2C1 = new Commentaire(content: "contentQ2C1", date: new Date())
				commentaireQ2C1.author = userQ2C1
				commentaireQ2C1.messageVotable = questionQ2
				questionQ2.addToCommentaires(commentaireQ2C1)
				commentaireQ2C1.save()
				// Commentaire Q2C2
				User userQ2C2 = new User(name: "userQ2C2Name", mail: "userQ2C2Adresse@mail.com", password: "userQ2C2Password")
				userQ2C2.save()
				Commentaire commentaireQ2C2 = new Commentaire(content: "contentQ2C2", date: new Date())
				commentaireQ2C2.author = userQ2C2
				commentaireQ2C2.messageVotable = questionQ2
				questionQ2.addToCommentaires(commentaireQ2C2)
				commentaireQ2C2.save()
			// Reponse Q2R1
			User userQ2R1 = new User(name: "userQ2R1Name", mail: "userQ2R1Adresse@mail.com", password: "userQ2R1Password")
			userQ2R1.save()
			Response responseQ2R1 = new Response(content: "contentQ2R1", date: new Date())
			responseQ2R1.author = userQ2R1
			responseQ2R1.question = questionQ2
			questionQ2.addToResponses(responseQ2R1)
			responseQ2R1.save()
				// Commentaire Q2R1C1
				User userQ2R1C1 = new User(name: "userQ2R1C1Name", mail: "userQ2R1C1Adresse@mail.com", password: "userQ2R1C1Password")
				userQ2R1C1.save()
				Commentaire commentaireQ2R1C1 = new Commentaire(content: "contentQ2R1C1", date: new Date())
				commentaireQ2R1C1.author = userQ2R1C1
				commentaireQ2R1C1.messageVotable = responseQ2R1
				responseQ2R1.addToCommentaires(commentaireQ2R1C1)
				commentaireQ2R1C1.save()
				// Commentaire Q2R1C2
				User userQ2R1C2 = new User(name: "userQ2R1C2Name", mail: "userQ2R1C2Adresse@mail.com", password: "userQ2R1C2Password")
				userQ2R1C2.save()
				Commentaire commentaireQ2R1C2 = new Commentaire(content: "contentQ2R1C2", date: new Date())
				commentaireQ2R1C2.author = userQ2R1C2
				commentaireQ2R1C2.messageVotable = responseQ2R1
				responseQ2R1.addToCommentaires(commentaireQ2R1C2)
				commentaireQ2R1C2.save()
			// Reponse Q2R2
			User userQ2R2 = new User(name: "userQ2R2Name", mail: "userQ2R2Adresse@mail.com", password: "userQ2R2Password")
			userQ2R2.save()
			Response responseQ2R2 = new Response(content: "contentQ2R2", date: new Date())
			responseQ2R2.author = userQ2R2
			responseQ2R2.question = questionQ2
			questionQ2.addToResponses(responseQ2R2)
			responseQ2R2.save()
				// Commentaire Q2R2C1
				User userQ2R2C1 = new User(name: "userQ2R2C1Name", mail: "userQ2R2C1Adresse@mail.com", password: "userQ2R2C1Password")
				userQ2R2C1.save()
				Commentaire commentaireQ2R2C1 = new Commentaire(content: "contentQ2R2C1", date: new Date())
				commentaireQ2R2C1.author = userQ2R2C1
				commentaireQ2R2C1.messageVotable = responseQ2R2
				responseQ2R2.addToCommentaires(commentaireQ2R2C1)
				commentaireQ2R2C1.save()
				// Commentaire Q2R2C2
				User userQ2R2C2 = new User(name: "userQ2R2C2Name", mail: "userQ2R2C2Adresse@mail.com", password: "userQ2R2C2Password")
				userQ2R2C2.save()
				Commentaire commentaireQ2R2C2 = new Commentaire(content: "contentQ2R2C2", date: new Date())
				commentaireQ2R2C2.author = userQ2R2C2
				commentaireQ2R2C2.messageVotable = responseQ2R2
				responseQ2R2.addToCommentaires(commentaireQ2R2C2)
				commentaireQ2R2C2.save()
		
		println "BDD initialisée :"
		println "- " + User.all.size() + " utilisateurs"
		println "- " + Question.all.size() + " questions"
		println "- " + Response.all.size() + " réponses"
		println "- " + Commentaire.all.size() + " commentaires"
	}
	
	
    def destroy = {
    }
	
}
