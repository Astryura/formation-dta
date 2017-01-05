package fr.pizzeria.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.other.JPADao;
import fr.pizzeria.dao.pizza.PizzaDao;

@Component
public class JdbcTemplateDaoFactory extends DaoFactory {

	@Autowired
	public JdbcTemplateDaoFactory(PizzaDao pizzadao) {
		super(pizzadao, new CommandeDaoJPA(new JPADao()), new LivreurDaoJPA(new JPADao()),
				new ClientDaoJPA(new JPADao()));
	}

}
