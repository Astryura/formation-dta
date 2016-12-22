package fr.pizzeria.admin.web.pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/api/servlet/pizzas")
@SuppressWarnings("serial")
public class PizzaServletWebApi extends HttpServlet {
	@Inject
	PizzaServiceEJB service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Pizza> list = service.findAll();
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
		service.savePizza(pizza);
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
		service.updatePizza(codePizza, pizza);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
		String codePizza = req.getParameter("codePizza");
		service.deletePizza(codePizza);
	}
}
