package fr.pizzeria.dao.livreur;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Livreur;

public class LivreurDaoTableau implements LivreurDao {

	List<Livreur> listLivreurs = new ArrayList<>();

	/**
	 * Constructeur
	 */
	public LivreurDaoTableau() {
		listLivreurs.add(new Livreur(0, "Jacques", "Dutronc"));
		listLivreurs.add(new Livreur(1, "Road", "Runner"));
		listLivreurs.add(new Livreur(2, "Beep", "Beep"));
	}

	@Override
	public void AddLivreur(Livreur livreur) {

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
