package fr.pizzeria.admin.web.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/*" }, description = "Request timer filter")
public class TechniqueFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void destroy() {
		config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();

		String name;
		String[] names = null;
		if (request instanceof HttpServletRequest) {
			name = ((HttpServletRequest) request).getRequestURI();
			names = name.split("/");
		}
		String info;
		if (names != null) {
			String last = names[(names.length) - 1];
			if (last.contains(".jsp")) {
				info = last.replaceAll(".jsp", "") + ": " + (after - before) + "ms";
			} else {
				info = "";
			}
		} else {
			info = "";
		}
		config.getServletContext().log(info);
		HttpSession session = ((HttpServletRequest) request).getSession();
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
		if (log != null) {
			log.add(info);
		} else {
			log = new ArrayList<>();
			log.add(info);
		}
		session.setAttribute("log", log);
	}
}
