package enums;

/**
 * @author MacBook
 * Klasse für Enum Film 
 */
public enum FilmAuswahl {
	FILMUPDATE("FILMUPDATE"),
	FILM("FILM");
	
	private final String label;
	
	/**
	 * Konstruktor
	 * @param label
	 */
	private FilmAuswahl(String label) {
	    this.label = label;
	}

	public String getLabel() {
	   return this.label;
	}

}
