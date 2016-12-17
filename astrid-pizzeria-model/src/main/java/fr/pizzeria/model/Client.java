package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author Astrid Hlavacek
 *
 */
@Entity
public class Client extends Personne {

	private String email;
	private String motDePasse;

	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;

	/**
	 * Constructeur par défault vide
	 */
	public Client() {
		super(null, null);
	}

	/**
	 * Constructeur sans id pour envoyer en base de donnée
	 * 
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param motDePasse
	 */
	public Client(String nom, String prenom, String email, String motDePasse) {
		super(nom, prenom);
		this.email = email;
		this.motDePasse = DigestUtils.md5Hex(motDePasse);
	}

	/**
	 * Constructeur complet pour récupérer un client de la base de donnée
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param motDePasse
	 */
	public Client(Integer id, String nom, String prenom, String email, String motDePasse) {
		super(id, nom, prenom);
		this.email = email;
		this.motDePasse = DigestUtils.md5Hex(motDePasse);
	}

	/**
	 * Constructeur email, mot de passe pour vérifier la connection
	 * 
	 * @param email
	 * @param motDePasse
	 */
	public Client(String email, String motDePasse) {
		super(null, null);
		this.email = email;
		this.motDePasse = DigestUtils.md5Hex(motDePasse);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = DigestUtils.md5Hex(motDePasse);
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}
