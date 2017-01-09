package fr.pizzeria.dao.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.service.client.ClientDaoJPA;
import fr.pizzeria.dao.service.commande.CommandeDao;
import fr.pizzeria.dao.service.livreur.LivreurDao;
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
	public JpaRepoDaoFactory(@Qualifier("JPARepo") PizzaDao pizzadao, CommandeDao commande, LivreurDao livreur) {
		super(pizzadao, commande, livreur, new ClientDaoJPA());
	}
}
