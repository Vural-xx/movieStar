package model;

import java.sql.Blob;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import abstracts.AbstractEntity;
import enums.Genre;

@ManagedBean(name="film")
@RequestScoped
public class Film extends AbstractEntity{
	private String name;
	private String beschreibung;
	private String erscheinungsjahr;
	private String dauer;
	private Benutzer ersteller;
	private double sterne;
	private List<Mitwirkende> mitwirkende;
	private List<Kommentar> kommentare;
	private Genre genre;
	private Blob titelbild;
	private List<Blob> gallerie;
	private List<Film> verwandteFilme;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public String getErscheinungsjahr() {
		return erscheinungsjahr;
	}
	public void setErscheinungsjahr(String erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}
	public String getDauer() {
		return dauer;
	}
	public void setDauer(String dauer) {
		this.dauer = dauer;
	}
	public Benutzer getErsteller() {
		return ersteller;
	}
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}
	public double getSterne() {
		return sterne;
	}
	public void setSterne(double sterne) {
		this.sterne = sterne;
	}
	public List<Mitwirkende> getMitwirkende() {
		return mitwirkende;
	}
	public void setMitwirkende(List<Mitwirkende> mitwirkende) {
		this.mitwirkende = mitwirkende;
	}
	public List<Kommentar> getKommentare() {
		return kommentare;
	}
	public void setKommentare(List<Kommentar> kommentare) {
		this.kommentare = kommentare;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Blob getTitelbild() {
		return titelbild;
	}
	public void setTitelbild(Blob titelbild) {
		this.titelbild = titelbild;
	}
	public List<Blob> getGallerie() {
		return gallerie;
	}
	public void setGallerie(List<Blob> gallerie) {
		this.gallerie = gallerie;
	}
	public List<Film> getVerwandteFilme() {
		return verwandteFilme;
	}
	public void setVerwandteFilme(List<Film> verwandteFilme) {
		this.verwandteFilme = verwandteFilme;
	}

}
