package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Livreur extends Personne {

	/**
	 * Liste des commandes à livrer
	 */
	@OneToMany(mappedBy = "livreur")
	public Set<Commande> commandes;

	/**
	 * Constructeur vide par défault
	 */
	public Livreur() {
		super(null, null);

	}

	/**
	 * Constructeur sans id pour envoyer en base de donnée
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Livreur(String nom, String prenom) {
		super(nom, prenom);
	}

	/**
	 * Constructeur complet pour récupérer un client de la base de donnée
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 */
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
