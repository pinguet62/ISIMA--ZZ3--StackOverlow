package fr.isima.stackoverlow

/**
 * TagLib liées aux tags
 * @author Julien
 */
class TagTagLib {
	
	/**
	 * Afficher l'icone d'un tag
	 * @param tag Tag
	 * @return Code HTML
	 */
	def stackTagIcon = { attrs, body ->
		Tag tag = attrs.tag
		if (tag == null)
			return out
		
		out << '<a class="post-tag" rel="tag" title="show questions tagged ' << tag.name << '" href="/StackOverlow/tag/' << tag.id << '">'
		out <<     tag.name
		out << '</a>'
		return out
	}
	
	
	/**
	 * Afficher l'icone d'un tag et sa popularité
	 * @param tag Tag
	 * @return Code HTML
	 */
	def stackTagIconAndPopularity = { attrs, body ->
		Tag tag = attrs.tag
		if (tag == null)
			return out
		
		out << g.stackTagIcon(tag: tag)
		out << '<span class="item-multiplier">'
		out <<     '<span class="item-multiplier-x"> x </span>'
		out <<     '<span class="item-multiplier-count">'
		out <<         new TagService().nbQuestionsTagged(tag)
		out <<     '</span>'
		out << '</span>'
		return out
	}
	
}