package fr.pizzeria.dao.exception;

/**
 * <h1>PizzaException</h1><b>Permet de gérer les exception runtime</b>
 * 
 * @author Astrid Hlavacek
 *
 */
public class PizzaException extends RuntimeException {

	/**
	 * Constructeur sans parametre
	 */
	public PizzaException() {
		super();
	}

	/**
	 * Consqtructeur ayant pour parametre un string et une exception
	 * 
	 * @param msg
	 * @param cause
	 */
	public PizzaException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Consqtructeur ayant pour parametre un string
	 * 
	 * @param msg
	 */
	public PizzaException(String msg) {
		super(msg);
	}

	/**
	 * Consqtructeur ayant pour parametre une exception
	 * 
	 * @param cause
	 */
	public PizzaException(Throwable cause) {
		super(cause);
	}

}
