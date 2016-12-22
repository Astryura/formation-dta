package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/connect/login")
@SuppressWarnings("serial")
public class LoginPizzaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/connect/login.jsp");
		dispatcher.forward(request, resp);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		if ("admin@pizzeria.fr".equals(email) && "admin".equals(mdp)) {
			session.setAttribute("email", email);
			session.setAttribute("mdp", mdp);
			resp.sendRedirect("/astrid-pizzeria-admin-app-1/pizzas/list");
		} else {
			resp.sendRedirect("/astrid-pizzeria-admin-app-1/connect/login");
		}
	}
}
