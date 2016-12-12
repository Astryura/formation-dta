package fr.pizzeria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numeroCommande;
	private Integer statut;
	private String dateCommande;

	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "livreurId")
	private Livreur livreur;

	@ManyToMany
	@JoinTable(name = "CommandePizza", joinColumns = @JoinColumn(name = "commandeId", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "pizzaId", referencedColumnName = "ID"))
	public Set<Pizza> pizzas = new HashSet<>();

	public Commande(Integer numeroCommande, Integer statut, String dateCommande, Client client, Livreur livreur) {
		super();
		this.numeroCommande = numeroCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.client = client;
		this.livreur = livreur;
	}

	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

}
