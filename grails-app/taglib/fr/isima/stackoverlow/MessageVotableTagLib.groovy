package fr.isima.stackoverlow

class MessageVotableTagLib {
	
	/**
	 * Afficher les options d'édition ou de suppression du message si l'utilisateur est l'auteur ou un administrateur
	 * @param user Utilisateur
	 * @param messageVotable Message
	 * @return code HTML
	 * @author Julien
	 */
	def stackMessageOptions = { attrs, body ->
		User user = attrs.user
		if (user == null)
			return out
		MessageVotable message = attrs.messageVotable
		if (message == null)
			return out
		
		out << '<div class="post-menu">'
		out <<     '<a class="suggest-comment-post" title="comment this post" onClick="showCommentaireForm(' << message.id << ')">comment</a>'
		UserService uService = new UserService()
		if (uService.isAuthorOrAdmin(user, message)) {
			out <<     '<span class="lsep"> | </span>'
			out <<     '<a class="suggest-edit-post" title="revise and improve this post" href="/StackOverlow/question/' << message.id << '/edit">edit</a>'
			out <<     '<span class="lsep"> | </span>'
			out <<     '<a class="suggest-remove-post" title="remove this post" href="/StackOverlow/question/' << message.id << '/delete">delete</a>'
		}
		out << '</div>'
		return out
	}
	
}
