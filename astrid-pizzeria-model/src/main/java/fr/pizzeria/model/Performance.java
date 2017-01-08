package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String service;

	private String date;

	private String tempsExecution;

	public Performance() {
		super();
	}

	public Performance(String service, String date, String tempsExecution) {
		super();
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(String tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
}
