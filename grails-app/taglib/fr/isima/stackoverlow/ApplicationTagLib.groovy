package fr.isima.stackoverlow

class ApplicationTagLib {
	
	/**
	 * Afficher la date
	 * Format : "MMM dd 'yy at HH:mm" ("Décem. 25 '13 at 20:55 ")
	 * Titre : "yyyy-MM-dd HH:MM:ss" ("2013-12-25 20:55:11")
	 * @param date Date
	 * @return Code HTML
	 */
	def stackDate = { attrs, body ->
		Date date = attrs.date
		if (date == null)
			return out
		
		out << '<span class="relativetime" title="' << date.format("yyyy-MM-dd HH:MM:ss") << '">'
		out <<     date.format("MMM dd") << " '" << date.format("yy") << " at " << date.format("HH:mm")
		out << '</span>'
		return out
	}
	
}
