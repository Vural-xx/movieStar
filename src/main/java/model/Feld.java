package model;

import java.io.Serializable;

/**
 * @author MacBook Klasse von Feld
 *
 */
public class Feld implements Serializable {

	private static final long serialVersionUID = -7316328572613877358L;
	private String label;
	private String value;

	/**
	 * Konstruktor
	 */
	public Feld() {
		//
	}

	/**
	 * Konstruktor
	 */
	public Feld(String label, String value) {
		this.label = label;
		this.value = value;
	}

	/**
	 * Getter von Beschreibung
	 * 
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Setter von Beschreibung
	 * 
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Getter von Wert
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter von Wert
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}