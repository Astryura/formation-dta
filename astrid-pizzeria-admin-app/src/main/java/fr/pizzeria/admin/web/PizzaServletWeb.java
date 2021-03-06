package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@WebServlet("/servlet/pizzas")
@SuppressWarnings("serial")
public class PizzaServletWeb extends HttpServlet {
	@Inject
	PizzaServiceEJB service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Pizza> list = service.findAll();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Tableau Pizzas</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=1>");
		out.println("<tr><th>Id</th><th>Code</th><th>Nom</th><th>Prix</th><th>Categorie</th></tr>");
		list.forEach(p -> out.write("<tr><td>" + p.getId() + "</td><td>" + p.getCode() + "</td><td>" + p.getNom()
				+ "</td><td>" + p.getPrix() + "</td><td>" + p.getCatP() + "</td></tr>"));
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
