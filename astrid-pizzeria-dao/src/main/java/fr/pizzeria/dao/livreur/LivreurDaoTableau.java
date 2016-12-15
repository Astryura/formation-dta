package fr.pizzeria.dao.livreur;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
		Comparator<Livreur> comp = Comparator.comparing(Livreur::getId);
		Optional<Livreur> l = listLivreurs.stream().max(comp);
		if (l.isPresent()) {
			Livreur max = l.get();
			livreur.setId(max.getId() + 1);
			listLivreurs.add(livreur);
		}

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
