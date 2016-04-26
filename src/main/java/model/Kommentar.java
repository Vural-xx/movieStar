package model;

public class Kommentar {
	private String text;
	private Kommentar kommentar;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Kommentar getKommentar() {
		return kommentar;
	}
	public void setKommentar(Kommentar kommentar) {
		this.kommentar = kommentar;
	}
	
	
}
