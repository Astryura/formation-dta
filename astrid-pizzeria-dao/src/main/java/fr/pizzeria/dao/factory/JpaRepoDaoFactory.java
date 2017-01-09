package fr.pizzeria.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.service.client.ClientDaoJPA;
import fr.pizzeria.dao.service.commande.CommandeDaoJPA;
import fr.pizzeria.dao.service.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.service.pizza.PizzaDao;
import fr.pizzeria.dao.service.pizza.PizzaDaoJPA;

@Component
@Qualifier("JPARepoFactory")
public class JpaRepoDaoFactory extends DaoFactory {

	/**
	 * instantiaction de PizzaDaoJPA
	 * 
	 * @see PizzaDaoJPA
	 */
	@Autowired
	public JpaRepoDaoFactory(@Qualifier("JPARepo") PizzaDao pizzadao) {
		super(pizzadao, new CommandeDaoJPA(), new LivreurDaoJPA(), new ClientDaoJPA());
	}
}
