package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/list")
@SuppressWarnings("serial")
public class ListerPizzaController extends HttpServlet {
	@Inject
	PizzaServiceEJB service;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		List<Pizza> list = service.findAll();
		request.setAttribute("listPizzas", list);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, resp);

	}

}
