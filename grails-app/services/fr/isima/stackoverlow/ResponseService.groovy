package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des messages votables (question ou réponse)
 * @author Julien
 */
class ResponseService extends MessageVotableService {
	
	/**
	 * Obtenir la liste des tags triée
	 * @param offset Id du premier tag
	 * @param max Nombre de tags
	 * @param sort Type de tri (DEFAULT, NEWEST, VOTES)
	 * @return Liste de tags
	 * @exception IllegalArgumentException Indices incorrects
	 * @exception IllegalArgumentException Tri incorrect
	 * @author Julien
	 * @TODO Tests
	 */
	def get(Question question, Sort sort) {
		// Tri
		// - DEFAULT : id croissant
		if (sort == Sort.DEFAULT)
			return Response.findAllByQuestion(question)
		// - OLDEST : date décroissante
		else if (sort == Sort.OLDEST)
			return Response.executeQuery(	"""
												SELECT response
												FROM Response response
												WHERE response.question = :question
												ORDER BY response.date ASC
											""", [question: question])
		// - VOTES : note décroissante, date décroissante
		else if (sort == Sort.VOTES) {
			def listQuestions = Question.executeQuery(	"""
															SELECT vote.messageVotable
															FROM Vote vote
															WHERE vote.messageVotable IN (SELECT response
																						  FROM Response response
																						  WHERE response.question = :question)
															  AND vote.mark > 0
															GROUP BY vote.messageVotable.id
															ORDER BY SUM(vote.mark) DESC,
															         vote.messageVotable.date DESC
														""", [question: question]) +
								Question.executeQuery(	"""
															SELECT response
															FROM Response response
															WHERE question NOT IN (SELECT vote.messageVotable FROM Vote vote WHERE vote.mark != 0)
															  AND response.question = :question
															GROUP BY question.id
															ORDER BY question.date DESC
														""", [question: question]) +
								Question.executeQuery(	"""
															SELECT vote.messageVotable
															FROM Vote vote
															WHERE vote.messageVotable IN (SELECT response
																						  FROM Response response
																						  WHERE response.question = :question)
															  AND vote.mark < 0
															GROUP BY vote.messageVotable.id
															ORDER BY SUM(vote.mark) DESC,
															         vote.messageVotable.date DESC
														""", [question: question])
			return listQuestions
		}
		else
			throw new IllegalArgumentException("Tri incorrect")
	}
	
	
	/**
	 * Supprimer
	 * @param reponse Réponse
	 * @exception ServiceException Echec de la suppression de la réponse
	 * @author Julien
	 * @TODO Tests
	 */
	def delete(Response reponse) {
		// Cascade
		for (Commentaire commentaire in reponse.commentaires)
			commentaire.delete()
		reponse.delete()
		
		// Echec
		if (Response.findById(reponse.id) != null)
			throw new ServiceException("Echec de la suppression de la réponse")
	}
	
	
	def getNbReponse(Question quest)
	{
		return Response.findAllByQuestion(quest).size();
		
	}
	
	
	def getResponseFromUser(User user)
	{
		List<Response> lst = Response.list()
		List<Response> ret = new ArrayList<Response>();
		for (Response r : lst)
		{
			Message m = (Message)r
			User auth = m.author
			if(auth.id == user.id)
			{
				ret.add(r)
			}
		}
		return ret
	}
	
}
