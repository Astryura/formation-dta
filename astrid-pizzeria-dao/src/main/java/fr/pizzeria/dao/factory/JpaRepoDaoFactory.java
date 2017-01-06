package fr.pizzeria.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoJPA;
import fr.pizzeria.dao.commande.CommandeDaoJPA;
import fr.pizzeria.dao.livreur.LivreurDaoJPA;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;

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
