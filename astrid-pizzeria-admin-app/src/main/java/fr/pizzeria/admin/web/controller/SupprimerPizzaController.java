package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;

@WebServlet("/pizzas/delete")
@SuppressWarnings("serial")
public class SupprimerPizzaController extends HttpServlet {
	@Inject
	PizzaServiceEJB service;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codePizza = req.getParameter("codePizza");
		service.deletePizza(codePizza);
		resp.sendRedirect("/astrid-pizzeria-admin-app-1/pizzas/list");
	}
}
