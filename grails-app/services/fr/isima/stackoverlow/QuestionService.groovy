package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des questions
 * @author Julien
 */
class QuestionService extends MessageVotableService {
	
	/**
	 * Obtenir la liste des questions, triée par ordre décroissant
	 * @param premier Id de la première question
	 * @param dernier Id de la dernière question
	 * @return Liste de questions
	 * @exception IllegalArgumentException Indices incorrects
	 * @TODO
	 */
	def getDesc(int premier, int dernier) {
		// Tests
		if (premier < 0 || dernier < premier)
			throw new IllegalArgumentException("Indices incorrects")
		
		int nb = dernier - premier + 1
		List<Question> listTags = Question.findAll([offset: premier, max: nb, order: "desc"])
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
