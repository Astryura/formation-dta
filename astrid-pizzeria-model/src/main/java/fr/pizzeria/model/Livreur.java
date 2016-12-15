package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Livreur extends Personne {

	@OneToMany(mappedBy = "livreur")
	public Set<Commande> commandes;

	public Livreur() {
		super(null, null);

	}

	public Livreur(String nom, String prenom) {
		super(nom, prenom);
	}

	public Livreur(Integer id, String nom, String prenom) {
		super(id, nom, prenom);
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}
