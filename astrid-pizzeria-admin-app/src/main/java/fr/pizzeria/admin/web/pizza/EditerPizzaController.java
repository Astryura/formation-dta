package fr.pizzeria.admin.web.pizza;

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

@SuppressWarnings("serial")
@WebServlet("/pizzas/editer")
public class EditerPizzaController extends HttpServlet {
	@Inject
	PizzaServiceEJB service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codePizza = req.getParameter("codePizza");
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String image = req.getParameter("img");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("cat").toUpperCase().replaceAll(" ", "_"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), image, catP);
		service.updatePizza(codePizza, pizza);
		resp.sendRedirect("/astrid-pizzeria-admin-app-1/pizzas/list");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String image = request.getParameter("img");
		CategoriePizza catP = CategoriePizza.valueOf(request.getParameter("cat").toUpperCase().replaceAll(" ", "_"));
		Pizza pizza = new Pizza(Integer.parseInt(id), code, nom, Double.parseDouble(prix), image, catP);
		request.setAttribute("pizza", pizza);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/pizzas/editerPizzas.jsp");
		dispatcher.forward(request, resp);
	}
}
