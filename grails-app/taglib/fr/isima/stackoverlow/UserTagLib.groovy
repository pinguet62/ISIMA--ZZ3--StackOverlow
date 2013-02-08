package fr.isima.stackoverlow

class UserTagLib {
	
	/**
	 * Afficher l'avatar
	 * @param user Utilisateur
	 * @return Code HTML
	 * @author Julien
	 */
	 def avatar = { attrs, body ->
		 User user = attrs.user
		 if (user == null)
		 	return out
		 
		 if (user.avatarUrl == null) {
			 out << g.img(dir: "images/avatar", file: "default.jpg", width: "32", height: "32")
		 } else if ('http'.equals(user.avatarUrl.substring(0, 4))) {
		 	out << '<img src="' << user.avatarUrl << '" width="32" height="32"/>'
		 } else {
		 	out << g.img(dir: "images", file: user.avatarUrl, width: "32", height: "32")
		 }
		 return out
	 }
	
}
