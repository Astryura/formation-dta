package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pizzas/technique")
@SuppressWarnings("serial")
public class TechniqueController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<String> log = (List<String>) session.getAttribute("log");
		Integer compteur = (Integer) session.getServletContext().getAttribute("compteur");
		request.setAttribute("info", log);
		request.setAttribute("nbSession", "Nombre de sessions ouvertes = " + compteur);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/connect/technique.jsp");
		dispatcher.forward(request, resp);

	}
}
