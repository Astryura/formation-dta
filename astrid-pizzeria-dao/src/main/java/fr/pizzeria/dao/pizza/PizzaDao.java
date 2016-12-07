package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAllPizzas();

	void saveNewPizza(Pizza pizza);

	void updatePizza(String codePizza, Pizza pizza);

	void deletePizza(String codePizza);

	List<Pizza> findAllPizzasCat();

	Pizza findAllPizzasPrix();
}
