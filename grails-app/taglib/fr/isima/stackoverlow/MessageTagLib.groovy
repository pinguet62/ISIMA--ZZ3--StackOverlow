package fr.isima.stackoverlow

import javassist.expr.Instanceof;

class MessageTagLib {
	
	/**
	 * Afficher un commentaire
	 * @param var Commentaire
	 * @return Code HTML
	 * @TODO Option si l'auteur du commentaire est celui de la question
	 * @TODO Formater la date
	 */
	def commentaire = { attrs, body ->
		Commentaire comm = attrs.var
		if (comm == null)
			return out
		
		def opt = ""/*(comm.author.equals( (comm.messageVotable instanceof Question
										? comm.messageVotable.author
										: comm.messageVotable.question.author) )
					? " owner"
					: "")*/
		
		out <<	'<tr id="comment-' << comm.messageVotable.id << '" class="comment">'
		out <<		'<td></td>'
		out << 		'<td class="comment-text">'
		out << 			'<div>'
		out << 				'<span class="comment-copy">'
		out << 					comm.content + " "
		out << 				'</span>'
		out << 				' - '
		out << 				'<a class="comment-user' << opt << '" href="/user/' << comm.author.id << '">'
		out << 					comm.author.name + " "
		out << 				'</a>'
		out << 				'<span class="comment-date" dir="ltr">'
		out << 					comm.date
		out << 				'</span>'
		out << 			'</div>'
		out << 		'</td>'
		out << '</tr>'
		return out
	}
	
	
	/**
	 * Afficher une réponse
	 * @param var Réponse
	 * @return Code HTML
	 */
	def response = { attrs, body ->
		
	}
	
}
