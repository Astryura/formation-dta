package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.pizzeria.admin.metier.TechniqueService;

@WebServlet("/pizzas/technique")
@SuppressWarnings("serial")
public class TechniqueController extends HttpServlet {
	@Inject
	TechniqueService service;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<String> log = (List<String>) session.getAttribute("log");
		Integer compteur = (Integer) session.getServletContext().getAttribute("compteur");
		request.setAttribute("info", log);
		request.setAttribute("nbSession", "Nombre de sessions ouvertes = " + compteur);
		request.setAttribute("listAdd", service.getListAdd());
		request.setAttribute("listUp", service.getListUp());
		request.setAttribute("listDel", service.getListDel());
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/connect/technique.jsp");
		dispatcher.forward(request, resp);

	}
}
