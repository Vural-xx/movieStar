package enums;

public enum FilmAuswahl {
	FILMUPDATE("FILMUPDATE"),
	FILM("FILM");
	
	private final String label;
	private FilmAuswahl(String label) {
	    this.label = label;
	}

	public String getLabel() {
	   return this.label;
	}

}
