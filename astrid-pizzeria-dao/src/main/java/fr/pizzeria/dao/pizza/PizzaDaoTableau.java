package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe gérant les Pizza enregistrées sous forme de tableau
 * 
 * @author Astrid Hlavacek
 *
 */
@Component
@Qualifier("Tableau")
public class PizzaDaoTableau implements PizzaDao {

	List<Pizza> listPizzas = new ArrayList<>();

	/**
	 * Constructeur
	 */
	public PizzaDaoTableau() {
		listPizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listPizzas.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listPizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		listPizzas.add(new Pizza(7, "IND", "L'indienne", 14.50, CategoriePizza.VIANDE));
		Pizza.setNbPizzas(listPizzas.size());
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getId);
		Optional<Pizza> p = listPizzas.stream().max(comp);
		if (p.isPresent()) {
			Pizza max = p.get();
			pizza.setId(max.getId() + 1);
			listPizzas.add(pizza);
			Pizza.setNbPizzas(listPizzas.size());
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		listPizzas.forEach(p -> {
			if (p.getCode().equals(codePizza)) {
				pizza.setId(p.getId());
				int a = listPizzas.indexOf(p);
				listPizzas.set(a, pizza);
			}
		});

	}

	@Override
	public void deletePizza(String codePizza) {

		Optional<Pizza> findFirst = listPizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();

		if (findFirst.isPresent()) {
			Pizza pizza = findFirst.get();
			listPizzas.remove(pizza);
		}

		Pizza.setNbPizzas(listPizzas.size());

	}

	@Override
	public void close() {
		Pizza.setNbPizzas(0);
		listPizzas.clear();
	}

}
