package fr.isima.stackoverlow

/**
 * Gestion des tags
 * @author Julien
 */
class TagService {
	
	/**
	 * Obtenir le nombre de questions taggués
	 * @param tag Tag
	 * @return Nombre de questions
	 */
	def nbQuestionsTagged(Tag tag) {
		int cpt = 0
		Question.all.each { question ->
			if (question.tags.contains(tag))
				cpt ++
		}
		return cpt
	}
	
	
	/**
	 * Obtenir la liste des tags triée
	 * @param offset Id du premier tag
	 * @param max Nombre de tags
	 * @param sort Type de tri
	 * @return Liste de tags
	 * @exception IllegalArgumentException Indices incorrects
	 * @exception IllegalArgumentException Tri incorrect
	 * @author Julien
	 */
	def get(int offset, int max, Sort sort) {
		// Tests
		if (offset < 0  ||  max < 0)
			throw new IllegalArgumentException("Paramètres incorrects")
		
		// Tri
		if (sort == Sort.DEFAULT)
			return Tag.findAll([offset: offset, max: max])
		else if (sort == Sort.POPULAR)
			return Tag.executeQuery(""" SELECT tag
										FROM Tag tag left join tag.questions as questions
										GROUP BY tag.id
										ORDER BY count(questions) desc, tag.name asc
									""", [offset: offset, max: max])
		else if (sort == Sort.NAME)
			return Tag.executeQuery(""" SELECT tag
										FROM Tag tag
										ORDER BY tag.name asc
									""", [offset: offset, max: max])
		else {
			throw new IllegalArgumentException("Tri incorrect")
		}
	}
	
	
	/**
	 * Obtenir le tag s'il existe ou le créer
	 * @param name Nom
	 * @return Tag
	 * @exception ServiceException Echec de la création
	 * @author Julien
	 */
	def getOrCreate(String name) {
		Tag tag = Tag.findOrCreateByName(name)
		
		// Echec
		if (tag == null)
			throw new ServiceException("Echec de la création")
		// Ok
			return tag
	}
	
	
	/**
	 * Mettre à jour
	 * @param tag Tag
	 * @exception ServiceException Echec de la mise à jour du tag
	 */
	def update(Tag tag) {
		def obj = tag.save()
		
		// Echec
		if (obj == null)
			throw new ServiceException("Echec de la mise à jour du tag")
	}
	
	
	def getTagFromUser(User u)
	{
		Map<Tag, Integer> mapTemp= new HashMap<Tag, Integer>()
		Map<Integer, List<Tag>> mapRet= new HashMap<Integer, Tag>()
		List<Tag> lst = Tag.list()
		
		
		for (Tag t : lst) 
		{
			for (Question q : t.questions) 
			{
				q = Question.findById(q.id)
				User author = q.author
				
					if(author.id == u.id)
					{
						if(!mapTemp.containsKey(t))
						{
							mapTemp.put(t, 0)
						}
						int val = mapTemp.get(t)
						++val;
						mapTemp.put(t, val)
					
					}
			}
			
		}
		
		for (Tag t : mapTemp.keySet()) 
		{
			if(!mapRet.containsKey(mapTemp.get(t)))
			{
				
				mapRet.put(mapTemp.get(t), new ArrayList<Tag>());
			}
			mapRet.get(mapTemp.get(t)).add(t);
		}
		return mapRet
	}
	
}
