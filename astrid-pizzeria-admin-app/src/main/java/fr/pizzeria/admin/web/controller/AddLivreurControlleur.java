package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.LivreurServiceEJB;
import fr.pizzeria.model.Livreur;

@WebServlet("/pizzas/addLivreur")
@SuppressWarnings("serial")
public class AddLivreurControlleur extends HttpServlet {
	@Inject
	LivreurServiceEJB service;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/livreurs/addLivreur.jsp");
		dispatcher.forward(request, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		Livreur livreur = new Livreur(nom, prenom);
		service.addLivreur(livreur);
		resp.sendRedirect("/astrid-pizzeria-admin-app-1/pizzas/list");
	}

}
