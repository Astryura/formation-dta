package fr.pizzeria.dao.service.livreur;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.model.Livreur;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
public class LivreurDaoTableau implements LivreurDao {

	/**
	 * initialisation de la liste des livreurs
	 */
	List<Livreur> listLivreurs = new ArrayList<>();

	/**
	 * Constructeur
	 */
	public LivreurDaoTableau() {
		listLivreurs.add(new Livreur(1, "Jacques", "Dutronc"));
		listLivreurs.add(new Livreur(2, "Road", "Runner"));
		listLivreurs.add(new Livreur(3, "Beep", "Beep"));
	}

	/**
	 * liste des livreurs
	 * 
	 * @return List<Livreur>
	 */
	public List<Livreur> allLivreur() {
		return listLivreurs;
	}

	@Override
	public void addLivreur(Livreur livreur) {
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
		listLivreurs.clear();

	}

}
