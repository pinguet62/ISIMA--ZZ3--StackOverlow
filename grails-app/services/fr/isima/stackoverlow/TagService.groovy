package fr.isima.stackoverlow

/**
 * Gestion des tags
 * @author Julien
 */
class TagService {
	
	/**
	 * Obtenir la liste des tags, triée par ordre décroissant dans le classement
	 * @param premier Classement du premier tag
	 * @param dernier Classement du dernier tag
	 * @return Liste de tags
	 * @exception IllegalArgumentException Arguments incorrects
	 */
    def getAsc(int premier, int dernier) {
		// Tests
		if (premier < 0 || dernier < premier)
			throw new IllegalArgumentException("Arguments incorrects")
		
		int nb = dernier - premier + 1
		List<Tag> listTags = Tag.findAll([offset: premier, max: nb, sort: "name", order: "asc"])
		return listTags
    }
	
	
	/**
	 * Obtenir le tag s'il existe ou le créer
	 * @param name Nom
	 * @return Tag
	 * @exception ServiceException Echec de la création
	 */
	def getOrCreate(String name) {
		Tag tag = null
		// Existant
		tag = Tag.findByName(name)
		if (tag != null)
			return tag
		// Créer
		tag = new Tag(name: name)
		def obj = tag.save()
		if (obj != null)
			return tag
		// Problème
		throw new ServiceException("Echec de la création")
	}
	
}
