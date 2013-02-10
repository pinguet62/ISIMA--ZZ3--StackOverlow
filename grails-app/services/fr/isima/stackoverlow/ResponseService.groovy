package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des messages votables (question ou réponse)
 * @author Julien
 */
class ResponseService extends MessageVotableService {
	
	/**
	 * Supprimer
	 * @param reponse Réponse
	 * @exception ServiceException Echec de la suppression du message
	 */
	def delete(Response reponse) {
		// Cascade
		for (Commentaire commentaire in reponse.commentaires)
			commentaire.delete()
		reponse.delete()
		
		// Echec
		if (Question.findById(reponse.id) != null)
			throw new ServiceException("Echec de la suppression du message")
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
