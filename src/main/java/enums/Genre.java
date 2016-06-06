package enums;

public enum Genre {
	ACTION("Action"),
	DRAMA("Drama"),
	COMEDY("Comedy"),
	SCIFI("Scifi");
	
	private final String label;
	private Genre(String label) {
	    this.label = label;
	}

	public String getLabel() {
	   return this.label;
	}
}
