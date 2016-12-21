package fr.pizzeria.admin.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CompteurSessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		Integer compteur = (Integer) event.getSession().getServletContext().getAttribute("compteur");
		if (compteur == null) {
			compteur = 1;
		} else {
			compteur++;
		}
		event.getSession().getServletContext().setAttribute("compteur", compteur);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
	}
}
