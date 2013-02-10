package fr.isima.stackoverlow

/**
 * Controlleur des pages des tags
 * @author Julien
 */
class TagController {
	
    /**
	 * Afficher la liste des tags
	 * @param page Numéro de page (optionnel)
	 * @param sort Type de tri
	 * @return Page des tags <br/>
	 *         Page d'erreur si inexistante
	 * @author Julien
	 */
	def all() {
		Sort.fromString(null)
		// Paramètres
		int pagesize = 36
		// - numéro de page
		int page = 1
		if (params.page != null)
			page = params.page.toInteger()
		// - tri
		Sort sort = Sort.POPULAR
		if (params.sort != null)
			sort = Sort.fromString(params.sort)
		else if (session.tag_sort != null)
			sort = session.tag_sort
		if (! [Sort.POPULAR, Sort.NAME].contains(sort))
			sort = Sort.POPULAR
		session.tag_sort = sort
		
		// Liste des tags
		int offset = pagesize*(page-1)
		int max = pagesize
		def listTags = new TagService().get(offset, max, sort)
		if (listTags.isEmpty())
			return render(view: "/notFound", model: [locality: "tags"])
		
		// Liste des pages
		int totalPages = Math.ceil(Tag.count / pagesize)
		def listPages = new Application().getListPages(page, totalPages)
		
		return render(view: "/tag/all", model: [listTags: listTags, sort: sort, currentPage: page, listPages: listPages])
	}
	
	
	/**
	 * Afficher un tag
	 * @param id Identifiant du tag
	 * @return Page du tag <br/>
	 *         Page d'erreur si inexistant
	 * @author Julien
	 */
	def show() {
		// Tag
		Tag tag = Tag.findById(params.id)
		if (tag == null)
			return render(view: "/notFound", model: [locality: "tags"])
		
		return render(view: "/tag/show", model: [tag: tag])
	}
	
	
	/**
	 * Editer une question
	 * @param id Identifiant de la question
	 * @return Page du formulaire <br/>
	 *         Page de connexion si l'utilisateur n'est pas connecté
	 * @author Julien
	 */
	def edit() {
		// Utilisateur connecté
		if (! UserController.isConnected())
			return redirect(url: "/user/login")
		
		// Question
		Tag tag = Tag.findById(params.id)
		if (tag == null)
			return render(view: "/notFound", model: [locality: "tags"])
		
		// Droits d'édition
		if (! UserController.getUser().admin)
			return redirect(url: "/tag/"+tag.id)
		
		return render(view: "/tag/edit", model: [tag: tag])
	}
	
	
	/**
	 * Valider l'édition d'un tag
	 * @param id Identifiant du tag
	 * @param description Description
	 * @return Page du tag <br/>
	 *         Page du formulaire si erreur
	 * @author Julien
	 */
	def edit_submit() {
		if (! UserController.isConnected())
			return redirect(url: "/user/login")
		
		// Tag
		Tag tag = Tag.findById(params.id)
		if (tag == null)
			return render(view: "/notFound", model: [locality: "tags"])
		
		// Droits d'édition
		if (! UserController.getUser().admin)
			redirect(url: "/tag/"+tag.id)
		
		// Vérifier le formulaire
		def listErreurs = []
		// - description
		if (params.description == null)
			listErreurs.add("body is missing")
		if (! listErreurs.isEmpty())
			return render(view: "/tag/edit", model: [tag: tag, listErreurs: listErreurs])
		
		try {
			// Modifier le tag
			tag.description = params.description
			// Sauvegarder
			TagService tService = new TagService()
			tService.update(tag)
			// Affichage
			return redirect(url: "/tag/"+tag.id)
		} catch (ServiceException e) {
			return render(view: "/tag/edit", model: [tag: tag, listErreurs: [e.getMessage()]])
		}
	}
	
}
