package fr.isima.stackoverlow

/**
 * M�thodes diverses utilis�es dans l'application
 * @author Julien
 */
class Application {
	
	/**
	 * Obtenir la liste des num�ros de page affich�es en bas d'une page
	 * @param currentPage Page courante
	 * @param totalPages Nombre total de pages
	 * @return Liste
	 * @exception IllegalArgumentException Nombre total de pages incorrect
	 * @exception IllegalArgumentException Page courrante incorrecte
	 */
	def getListPages(int currentPage, int totalPages) {
		if (totalPages <= 0)
			throw new IllegalArgumentException("Nombre total de pages incorrect")
		if (currentPage <= 0  ||  totalPages < currentPage)
			throw new IllegalArgumentException("Page courrante incorrecte")
		
		def listPages = []
		// 1 � 6 pages : toutes les afficher
		if (totalPages <= 6) {
			for (int i=1 ; i<=totalPages ; i++)
				listPages.add(i)
		}
		// points de suspension
		else {
			// 1 � 4 : �a ne change pas
			if (currentPage <= 4)
				listPages = [1, 2, 3, 4, 5, totalPages]
			// 5 � n-4 : 
			else if (totalPages-3 <= currentPage)
				listPages = [1, totalPages-4, totalPages-3, totalPages-2, totalPages-1, totalPages]
			// (n-3) � n : �a ne change pas
			else
				listPages = [1, currentPage-2, currentPage-1, currentPage, currentPage+1, currentPage+2, totalPages]
		}
		return listPages
	}
	
}
