package model;

import enums.FilmRolle;

public class Mitwirkende {
	private String name;
	private String vorname;
	private FilmRolle filmRolle;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public FilmRolle getFilmRolle() {
		return filmRolle;
	}
	public void setFilmRolle(FilmRolle filmRolle) {
		this.filmRolle = filmRolle;
	}
	
	
}
