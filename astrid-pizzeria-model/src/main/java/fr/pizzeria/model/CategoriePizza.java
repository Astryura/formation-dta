package fr.pizzeria.model;

/**
 * Enumération
 * 
 * @author Astrid Hlavacek
 *
 */
public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	private String name = "";

	/**
	 * Constructeur
	 * 
	 * @param name
	 */
	CategoriePizza(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
