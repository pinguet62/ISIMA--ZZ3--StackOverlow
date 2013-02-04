package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des questions
 * @author Julien
 */
class QuestionService extends MessageVotableService {
	
	def create(Question question) {
		// Champs nulls
		if (question.responses == null)
			question.responses = []
		if (question.tags == null  ||  question.tags == [])
			throw new ServiceException("Tags obligatoires")
		
		def obj = question.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la création de la question")
	}
	
	
	/**
	 * Obtenir la liste des questions, triée par ordre décroissant
	 * @param offset Id de la première question
	 * @param max Nombre de questions
	 * @return Liste de questions
	 * @exception IllegalArgumentException Indices incorrects
	 * @TODO tri
	 * @author Julien
	 */
	def getDesc(int offset, int max) {
		// Tests
		if (offset < 0  ||  max < 0)
			throw new IllegalArgumentException("Paramètres incorrects")
		
		List<Question> listTags = Question.findAll([offset: offset, max: max, order: "desc"])
		return listTags
	}
	
	
	def getQuestionFromUser(User user)
	{
		List<Question> lst = Question.list()
		List<Question> ret = new ArrayList<Question>();
		for (Question q : lst) 
		{
			Message m = (Message)q
			User auth = m.author
			if(auth.id == user.id)
			{
				ret.add(q)
			}	
		}
		return ret
	}
	
	
	/**
	 * Cacher
	 * @param question Question
	 * @author Julien
	 */
	def disable(Question question) {
		// Cascade
		for (Response reponse in question.responses) {
			for (Commentaire commentaire in reponse.commentaires)
				commentaire.disable()
			reponse.disable()
		}
		question.disable()
	}
	
	
	/**
	 * Supprimer
	 * @param question Question
	 * @exception ServiceException Echec de la suppression du message
	 * @author Julien
	 */
	def delete(Question question) {
		// Cascade
		for (Response reponse in question.responses) {
			for (Commentaire commentaire in reponse.commentaires)
				commentaire.delete()
			reponse.delete()
		}
		question.delete()
		
		// Echec
		if (Question.findById(question.id) != null)
			throw new ServiceException("Echec de la suppression du message")
	}
	
}
