package fr.isima.stackoverlow

import fr.isima.stackoverlow.ServiceException

/**
 * Gestion des questions
 * @author Julien
 */
class QuestionService extends MessageVotableService {
	
	/**
	 * Obtenir la liste des questions, triée par ordre décroissant
	 * @param offset Id de la première question
	 * @param max Nombre de questions
	 * @return Liste de questions
	 * @exception IllegalArgumentException Indices incorrects
	 * @TODO
	 */
	def getDesc(int offset, int max) {
		// Tests
		if (offset < 0 || max <= 0)
			throw new IllegalArgumentException("Indices incorrects")
		
		return Question.findAll([offset: offset, max: max, order: "desc"])
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
