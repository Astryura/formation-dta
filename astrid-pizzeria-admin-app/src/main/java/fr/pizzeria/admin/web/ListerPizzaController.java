package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/list")
@SuppressWarnings("serial")
public class ListerPizzaController extends HttpServlet {
	private final transient PizzaDao pizzaDao = new PizzaDaoJPA(new JPADao());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		List<Pizza> list = pizzaDao.findAllPizzas();
		request.setAttribute("listPizzas", list);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, resp);

	}

}
