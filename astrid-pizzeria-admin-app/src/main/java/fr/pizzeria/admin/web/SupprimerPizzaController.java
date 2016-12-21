package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;

@WebServlet("/pizzas/delete")
@SuppressWarnings("serial")
public class SupprimerPizzaController extends HttpServlet {
	private final transient PizzaDao pizzaDao = new PizzaDaoJPA(new JPADao());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codePizza = req.getParameter("codePizza");
		pizzaDao.deletePizza(codePizza);
		resp.sendRedirect("/astrid-pizzeria-admin-app/pizzas/list");
	}
}
