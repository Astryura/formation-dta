package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/pizzas/*" }, description = "Authentification")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		if ("admin@pizzeria.fr".equals(session.getAttribute("email")) && "admin".equals(session.getAttribute("mdp"))) {
			chain.doFilter(req, res);
		} else {
			((HttpServletResponse) res).sendRedirect("/astrid-pizzeria-admin-app-1/connect/login");
		}

	}

	@Override
	public void destroy() {

	}

}
