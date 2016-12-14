package fr.pizzeria.dao.commande;

import java.util.List;

import fr.pizzeria.dao.JPADao;
import fr.pizzeria.model.Commande;

public class CommandeDaoJBDC implements CommandeDao {

	@Override
	public void NewCommande(Integer id, String codePizza, JPADao jpaDao) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> ListCommandeClient(Integer id, JPADao jpaDao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> ListCommande(JPADao jpaDao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ExpedtionCommande(Integer num, JPADao jpaDao) {
		// TODO Auto-generated method stub

	}

}
