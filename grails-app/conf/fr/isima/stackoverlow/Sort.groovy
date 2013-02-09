package fr.isima.stackoverlow

/**
 * Défini les types de tri dans les pages
 * @author Julien
 */
enum Sort {
	
	DEFAULT("default"),
	NEWEST("newest"),
	OLDEST("oldest"),
	POPULAR("popular"),
	NAME("name"),
	REPUTATION("reputation")
	
	private final String text
	
	
	/**
	 * Constructeur
	 * @param text String
	 */
	private Sort(String text) {
		this.text = text
	}
	
	
	/**
	 * Obtenir le type de tri à partir de son String
	 * @param text String
	 * @return Sort
	 */
	static Sort fromString(String text) {
		for (Sort sort : Sort.values())
			if (sort.text.equals(text))
				return sort
		return null
	}
	
	
	/**
	 * Obtenir la valeur sous forme de String
	 * @return String
	 */
	String toString() {
		return text
	}
	
}
