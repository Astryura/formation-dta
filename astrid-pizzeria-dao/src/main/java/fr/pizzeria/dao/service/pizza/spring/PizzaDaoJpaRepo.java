package fr.pizzeria.dao.service.pizza.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repo.pizza.PizzaRepository;
import fr.pizzeria.dao.service.pizza.PizzaDao;
import fr.pizzeria.dao.service.pizza.PizzaDaoTableau;
import fr.pizzeria.model.Pizza;

@Component
@Qualifier("JPARepo")
public class PizzaDaoJpaRepo implements PizzaDao {
	@Autowired
	PizzaRepository pizzaRepo;

	@Override
	public List<Pizza> findAllPizzas() {
		Pizza.setNbPizzas(pizzaRepo.findAll().size());
		return pizzaRepo.findAll();
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzaRepo.save(pizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza p = pizzaRepo.findByCode(codePizza);
		pizzaRepo.delete(p);
		pizzaRepo.save(pizza);
	}

	@Override
	public void deletePizza(String codePizza) {
		Pizza p = pizzaRepo.findByCode(codePizza);
		pizzaRepo.delete(p);
	}

	@Override
	public void close() {
		//
	}

	@Override
	public void importDataPizza() {
		PizzaDao pizzadao = new PizzaDaoTableau();
		List<Pizza> listPizzas = pizzadao.findAllPizzas();
		for (Pizza pizza : listPizzas) {
			pizzaRepo.save(pizza);
		}

	}

}
