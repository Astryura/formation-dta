package fr.pizzeria.dao.commande;

import java.util.List;

import fr.pizzeria.dao.other.FichierDao;
import fr.pizzeria.model.Commande;

public class CommandeDaoFichier implements CommandeDao {

	public CommandeDaoFichier(FichierDao fichierDao) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void NewCommande(Integer id, String codePizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> ListCommandeClient(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> ListCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ExpedtionCommande(Integer num) {
		// TODO Auto-generated method stub

	}

}
