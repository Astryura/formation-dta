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

import fr.pizzeria.admin.metier.CommandeServiceEJB;
import fr.pizzeria.model.Commande;

@WebServlet("/pizzas/listCommande")
@SuppressWarnings("serial")
public class ListerCommandeController extends HttpServlet {
	@Inject
	CommandeServiceEJB service;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		List<Commande> list = service.findAll();
		request.setAttribute("listCommandes", list);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/commandes/listerCommandes.jsp");
		dispatcher.forward(request, resp);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String numero = request.getParameter("numero");
		service.expedtionCommande(Integer.parseInt(numero));
		resp.sendRedirect("/astrid-pizzeria-admin-app-1/pizzas/listCommande");
	}
}
