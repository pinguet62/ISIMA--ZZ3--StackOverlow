package fr.isima.stackoverlow

/**
 * TagLib liées aux tags
 * @author Julien
 */
class TagTagLib {
	
	/**
	 * Afficher un tag
	 * @param tag Tag
	 * @return Code HTML
	 */
	def tagIcone = { attrs, body ->
		Tag tag = attrs.tag
		if (tag == null)
			return out
		
		out << '<a class="post-tag" rel="tag" title="show questions tagged ' << tag.name << '" href="/tag/' << tag.id << '">'
		out <<     tag.name
		out << '</a>'
		return out
	}
	
}