package fr.pizzeria.dao.service.pizza;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	default List<Pizza> findAllPizzasCat() {
		List<Pizza> listPizzas = findAllPizzas();
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getCatP);
		return listPizzas.stream().sorted(comp).collect(Collectors.toList());
	}

	/**
	 * Trouve la Pizza la plus chère
	 * 
	 * @return Pizza
	 */
	default Pizza findPrixMaxPizza() {
		List<Pizza> listPizzas = findAllPizzas();
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getPrix);
		Optional<Pizza> pizza = listPizzas.stream().max(comp);
		if (pizza.isPresent()) {
			return pizza.get();
		} else {
			return null;
		}
	}

	/**
	 * Import les données fichiers ou Tableaux en BDD (PizzaDaoJDBC ou
	 * PizzaDaoJPA)
	 * 
	 * @see PizzaDaoJDBC
	 * @see PizzaDaoJPA
	 */
	default void importDataPizza() {
		throw new PizzaException("pas d'implémentation");
	}

	/**
	 * Ferme le PizzaDao
	 */
	void close();
}
