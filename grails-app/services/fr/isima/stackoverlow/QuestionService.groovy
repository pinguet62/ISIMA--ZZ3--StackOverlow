package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des questions
 * @author Julien
 */
class QuestionService extends MessageVotableService {
	
	/**
	 * Obtenir la liste des tags tri�e
	 * @param offset Id du premier tag
	 * @param max Nombre de tags
	 * @param sort Type de tri (DEFAULT, NEWEST, VOTES)
	 * @return Liste de tags
	 * @exception IllegalArgumentException Indices incorrects
	 * @exception IllegalArgumentException Tri incorrect
	 * @author Julien
	 */
	def get(int offset, int max, Sort sort) {
		// Tests
		if (offset < 0  ||  max < 0)
			throw new IllegalArgumentException("Param�tres incorrects")
		
		// Tri
		// - DEFAULT : id croissant
		if (sort == Sort.DEFAULT)
			return Question.findAll([offset: offset, max: max])
		// - NEWEST : date d�croissante
		else if (sort == Sort.NEWEST)
			return Question.executeQuery(	"""
												SELECT question
												FROM Question question
												ORDER BY question.date DESC
											""", [offset: offset, max: max])
		// - VOTES : note d�croissante, date d�croissante
		else if (sort == Sort.VOTES) { // TODO: proprement...
			def listQuestions = Question.executeQuery(	"""
															SELECT vote.messageVotable
															FROM Vote vote
															WHERE vote.messageVotable IN (SELECT question FROM Question question)
																AND vote.mark > 0
															GROUP BY vote.messageVotable.id
															ORDER BY SUM(vote.mark) DESC,
															         vote.messageVotable.date DESC
														""") +
								Question.executeQuery(	"""
															SELECT question
															FROM Question question
															WHERE question NOT IN (SELECT vote.messageVotable FROM Vote vote WHERE vote.mark != 0)
															GROUP BY question.id
															ORDER BY question.date DESC
														""") +
								Question.executeQuery(	"""
															SELECT vote.messageVotable
															FROM Vote vote
															WHERE vote.messageVotable IN (SELECT question FROM Question question)
																AND vote.mark < 0
															GROUP BY vote.messageVotable.id
															ORDER BY SUM(vote.mark) DESC,
															         vote.messageVotable.date DESC
														""")
			int last = (listQuestions.size() < offset+max ? listQuestions.size()-1 : offset+max-1)
			return listQuestions[offset..last]
		}
		else
			throw new IllegalArgumentException("Tri incorrect")
	}
	
	
	/**
	 * @param message Message
	 * @param question Question
	 * @exception ServiceException Tags inexistants
	 * @exception ServiceException Echec de la cr�ation du message
	 * @author Julien
	 */
	def create(Question question) {
		// Champs nulls
		if (question.responses == null)
			question.responses = []
		if (question.tags == null  ||  question.tags == [])
			throw new ServiceException("Tags inexistants")
		
		def obj = question.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la cr�ation de la question")
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
	
}
