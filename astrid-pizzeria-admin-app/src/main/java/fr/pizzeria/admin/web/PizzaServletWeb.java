package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Pizza;

public class PizzaServletWeb extends HttpServlet {

	private PizzaDao pizzaDao = new PizzaDaoJPA(new JPADao());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Pizza> list = pizzaDao.findAllPizzas();
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
