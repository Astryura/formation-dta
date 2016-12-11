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

/**
 * <b>Pizza est la classe représentant une Pizza.</b>
 * <p>
 * Une Pizza est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>Un code permettant de retrouver la Pizza.</li>
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Une Catégorie indiquant le type de garniture de la Pizza.</li>
 * </ul>
 * </p>
 * <p>
 * De plus on enregistre le nombre de Pizza créée
 * </p>
 * 
 */

@Entity
@Table(name = "PIZZA")
public class Pizza {

	/**
	 * L'ID de la Pizza. Cet ID n'est pas modifiable.
	 * 
	 * @see Pizza#id
	 * @see Pizza#Pizza(Integer, String, String, double, CategoriePizza)
	 * @see Pizza#getId()
	 * @see Pizza#setId(Integer)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	/**
	 * Le CODE de la Pizza.
	 * 
	 * @see Pizza#code
	 * @see Pizza#Pizza(Integer, String, String, double, CategoriePizza)
	 * @see Pizza#Pizza(String, String, double, CategoriePizza)
	 * @see Pizza#getCode()
	 * @see Pizza#setCode(String)
	 */
	@Column(name = "CODE", length = 3)
	private String code;

	/**
	 * Le NOM de la Pizza
	 * 
	 * @see Pizza#nom
	 * @see Pizza#Pizza(Integer, String, String, double, CategoriePizza)
	 * @see Pizza#Pizza(String, String, double, CategoriePizza)
	 * @see Pizza#getNom()
	 * @see Pizza#setNom(String)
	 */
	@Column(name = "NOM")
	private String nom;

	/**
	 * Le PRIX de la Pizza
	 * 
	 * @see Pizza#prix
	 * @see Pizza#Pizza(Integer, String, String, double, CategoriePizza)
	 * @see Pizza#Pizza(String, String, double, CategoriePizza)
	 * @see Pizza#getPrix()
	 * @see Pizza#setPrix(double)
	 */
	@Column(name = "PRIX")
	private double prix;

	/**
	 * La catégorie de la Pizza. Type énuméré
	 * 
	 * @see Pizza#catP
	 * @see Pizza#Pizza(Integer, String, String, double, CategoriePizza)
	 * @see Pizza#Pizza(String, String, double, CategoriePizza)
	 * @see Pizza#getCatP()
	 * @see Pizza#setCatP(CategoriePizza)
	 */
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
		// nbPizzas++;
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
}
