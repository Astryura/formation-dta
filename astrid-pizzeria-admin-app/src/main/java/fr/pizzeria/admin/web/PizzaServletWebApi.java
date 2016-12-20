package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@SuppressWarnings("serial")
public class PizzaServletWebApi extends HttpServlet {

	private final transient PizzaDao pizzaDao = new PizzaDaoJPA(new JPADao());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Pizza> list = pizzaDao.findAllPizzas();
		PrintWriter out = resp.getWriter();
		list.forEach(p -> out.write(
				p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCatP() + "\n"));
		out.write(Pizza.getNbPizzas() + " Pizzas enregistrées");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("cat"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		pizzaDao.saveNewPizza(pizza);
		resp.setStatus(201);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
		String codePizza = req.getParameter("codePizza");
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("cat"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		pizzaDao.updatePizza(codePizza, pizza);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
		String codePizza = req.getParameter("codePizza");
		pizzaDao.deletePizza(codePizza);
	}
}
