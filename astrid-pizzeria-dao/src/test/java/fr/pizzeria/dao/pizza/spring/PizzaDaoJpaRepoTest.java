package fr.pizzeria.dao.pizza.spring;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.config.PizzaDaoConfigTest;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoConfigTest.class)
public class PizzaDaoJpaRepoTest {
	@Autowired
	@Qualifier("JPARepo")
	PizzaDao pizzaDao;

	@Test
	public void saveNewPizzaTest() {
		Pizza p = new Pizza("HAA", "Harissa", 14.56, CategoriePizza.VIANDE);
		pizzaDao.saveNewPizza(p);
		List<Pizza> list = pizzaDao.findAllPizzas();
		Optional<Pizza> pizza = list.stream().filter(piz -> piz.getCode().equals(p.getCode())).findFirst();
		if (pizza.isPresent()) {
			pizza.get().equals(p);
		}
		pizzaDao.deletePizza(p.getCode());
	}

	@Test
	public void updatePizzaTest() {
		Pizza p = new Pizza("ERI", "L'indienne", 13.2, CategoriePizza.POISSON);
		pizzaDao.saveNewPizza(p);
		Pizza p2 = new Pizza(7, "ERI", "Indienne", 13.2, CategoriePizza.POISSON);
		String code = "ERI";
		pizzaDao.updatePizza(code, p2);
		List<Pizza> list = pizzaDao.findAllPizzas();
		Optional<Pizza> pizza = list.stream().filter(piz -> piz.getCode().equals(p2.getCode())).findFirst();
		if (pizza.isPresent()) {
			pizza.get().equals(p2);
		}

	}

	@Test
	public void deletePizzaTest() {
		Pizza p = new Pizza("RAP", "Party", 14.56, CategoriePizza.VIANDE);
		pizzaDao.saveNewPizza(p);
		String code = "RAP";
		pizzaDao.deletePizza(code);
		List<Pizza> list = pizzaDao.findAllPizzas();
		Optional<Pizza> pizza = list.stream().filter(piz -> piz.getCode().equals(code)).findFirst();
		if (pizza.isPresent()) {
			fail("N'a pas été supprimée");
		}
	}
}
