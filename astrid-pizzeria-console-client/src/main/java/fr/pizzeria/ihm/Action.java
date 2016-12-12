package fr.pizzeria.ihm;

/**
 * <h1>Action</h1> <b>Interface définissant les mennus.</b>
 * 
 * @author Astrid Hlavacek
 *
 */
public interface Action {

	/**
	 * Méthode doAction, redéfinie dans chaque classe implémentant l'interface
	 * Action. Elle indique l'Action à effectuer.
	 */
	void doAction();

	/**
	 * Méthode describeAction, redéfinie dans chaque classe implémentant
	 * l'interface Action. Elle indique le nom de l'Action.
	 */
	void describeAction();
}
