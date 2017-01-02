package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDaoREST;

public class RESTDaoFactory extends DaoFactory {

	public RESTDaoFactory() {
		super(new PizzaDaoREST(), new CommandeDaoJPA(new JPADao()), new LivreurDaoJPA(new JPADao()),
				new ClientDaoJPA(new JPADao()));
	}

}
