package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "PIZZA")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "CODE", length = 3)
	private String code;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRIX")
	private double prix;
	@Enumerated(EnumType.STRING)
	@Column(name = "CATEGORIE")
	private CategoriePizza catP;
	@Transient
	private static int nbPizzas;

	public Pizza(Integer id, String code, String nom, double prix, CategoriePizza catP) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbPizzas++;
		this.catP = catP;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza catP) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.catP = catP;
	}

	public Pizza() {
	}

	public String getCatP() {
		return catP.toString().toUpperCase().replaceAll(" ", "_");
	}

	public void setCatP(CategoriePizza catP) {
		this.catP = catP;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) obj;
		return new EqualsBuilder().append(id, rhs.id).append(code, rhs.code).append(nom, rhs.nom).append(prix, rhs.prix)
				.append(catP, rhs.catP).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(nom).append(id).toHashCode();
	}
}
