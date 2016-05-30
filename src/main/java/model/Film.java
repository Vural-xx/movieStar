package model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enums.Genre;

@ManagedBean(name="film")
@RequestScoped
@Entity
@Table(name = "Filme")
public class Film implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -550197280185627795L;
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "beschreibung")
	private String beschreibung;
	
	@Column(name = "erscheinungsjahr")
	private String erscheinungsjahr;
	
	@Column(name = "dauer")
	private String dauer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ersteller", nullable = false)
	private Benutzer ersteller;
	
	@Column(name = "sterne")
	private double sterne;
	
	/*
	
	@ManyToMany
	@JoinColumn(name = "mitwirkende_id")
	private List<Mitwirkende> mitwirkende;
	
	@OneToMany
	@JoinColumn(name = "kommentare_id")
	private List<Kommentar> kommentare;
	
	@OneToMany
	@JoinColumn(name = "genre_id")
	@Enumerated(EnumType.STRING)
	private List<Genre> genre;
	
	@Column(name="titelbild")
	private Blob titelbild;
	
	@OneToMany
	@JoinColumn(name = "gallerie")
	private List<Blob> gallerie;
	
	@Column(name="verwandte_filme")
	private List<Film> verwandteFilme;
	
	*/
	
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
	/*
	
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
	
	
	public List<Genre> getGenre() {
		return genre;
	}
	public void setGenre(List<Genre> genre) {
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
	} */

}
