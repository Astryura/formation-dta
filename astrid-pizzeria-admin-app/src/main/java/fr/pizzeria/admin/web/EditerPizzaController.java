package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@SuppressWarnings("serial")
public class EditerPizzaController extends HttpServlet {
	private final transient PizzaDao pizzaDao = new PizzaDaoJPA(new JPADao());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codePizza = req.getParameter("codePizza");
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("cat").toUpperCase().replaceAll(" ", "_"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		pizzaDao.updatePizza(codePizza, pizza);
		resp.sendRedirect("/astrid-pizzeria-admin-app/pizzas/list");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(request.getParameter("cat").toUpperCase().replaceAll(" ", "_"));
		Pizza pizza = new Pizza(Integer.parseInt(id), code, nom, Double.parseDouble(prix), catP);
		request.setAttribute("pizza", pizza);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/pizzas/editerPizzas.jsp");
		dispatcher.forward(request, resp);
	}
}
