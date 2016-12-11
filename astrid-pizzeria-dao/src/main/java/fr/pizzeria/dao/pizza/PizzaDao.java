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
	 * @throws PizzaException
	 */
	List<Pizza> findAllPizzas() throws PizzaException;

	/**
	 * Enregistre une nouvelle Pizza
	 * 
	 * @param pizza
	 * @throws PizzaException
	 */
	void saveNewPizza(Pizza pizza) throws PizzaException;

	/**
	 * Modifie une Pizza
	 * 
	 * @param codePizza
	 * @param pizza
	 * @throws PizzaException
	 */
	void updatePizza(String codePizza, Pizza pizza) throws PizzaException;

	/**
	 * Supprime une Pizza
	 * 
	 * @param codePizza
	 * @throws PizzaException
	 */
	void deletePizza(String codePizza) throws PizzaException;

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
	 * @throws PizzaException
	 * @see PizzaDaoJDBC
	 */
	default void importDataPizza() throws PizzaException {
		throw new PizzaException("pas d'implémentation");
	}

	/**
	 * Ferme le PizzaDao
	 */
	void close();
}
