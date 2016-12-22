package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/add")
@SuppressWarnings("serial")
public class AddPizzaController extends HttpServlet {
	@Inject
	PizzaServiceEJB service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("cat").toUpperCase().replaceAll(" ", "_"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		service.savePizza(pizza);
		resp.sendRedirect("/astrid-pizzeria-admin-app-1/pizzas/list");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/pizzas/addPizza.jsp");
		dispatcher.forward(request, resp);
	}
}
