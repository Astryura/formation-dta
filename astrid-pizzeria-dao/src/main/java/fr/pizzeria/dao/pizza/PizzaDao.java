package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

/**
 * Interface définissant les actions possible d'une PizzaDao
 * 
 * @author Astrid Hlavacek
 *
 */
public interface PizzaDao {

	/**
	 * retroune la liste de toutes les Pizzas
	 * 
	 * @return List<Pizza>
	 */
	List<Pizza> findAllPizzas();

	/**
	 * Enregistre une nouvelle Pizza
	 * 
	 * @param pizza
	 */
	void saveNewPizza(Pizza pizza);

	/**
	 * Modifie une Pizza
	 * 
	 * @param codePizza
	 * @param pizza
	 */
	void updatePizza(String codePizza, Pizza pizza);

	/**
	 * Supprime une Pizza
	 * 
	 * @param codePizza
	 */
	void deletePizza(String codePizza);

	/**
	 * retourne la liste de Pizza par ordre de catégorie
	 * 
	 * @return List<Pizza>
	 */
	List<Pizza> findAllPizzasCat();

	/**
	 * Trouve la Pizza la plus chère
	 * 
	 * @return Pizza
	 */
	Pizza findPrixMaxPizza();

	/**
	 * Import les données fichiers ou Tableaux en BDD (PizzaDaoJDBC)
	 * 
	 * @see PizzaDaoJDBC
	 */
	default void importDataPizza() {
		throw new PizzaException("pas d'implémentation");
	}

	/**
	 * Ferme le PizzaDao
	 */
	void close();
}
