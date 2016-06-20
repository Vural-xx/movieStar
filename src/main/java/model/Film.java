package model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enums.Genre;

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
	@JoinColumn(name = "ersteller")
	private Benutzer ersteller;
	
	@Column(name = "sterne")
	private double sterne;
	
	@Column(name = "uploaddatum")
	private Timestamp uploaddatum;
		
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "film_mitwirkende", joinColumns = { 
			@JoinColumn(name = "film_name") }, 
			inverseJoinColumns = { @JoinColumn(name = "mitwirkende_name") })
	private List<Mitwirkende> mitwirkende = new ArrayList<Mitwirkende>(0);
	
	@OneToMany
	@JoinColumn(name = "unterkommentare_id")
	private List<Kommentar> kommentare;
	
	@OneToMany
	@JoinColumn(name = "bewertungen_id")
	private List <Bewertung> bewertungen = new ArrayList<Bewertung>(0);
	
	@ElementCollection(targetClass = Genre.class)
	@Column(name = "genres", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Genre> genres;
	
	@Column(name = "genres", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Column(name="titelbild")
	@Lob
	private Blob titelbild;
	
	/*
	@Column(name = "gallerie" )
	@Lob
	private List<Blob> gallerie = new ArrayList<Blob>(0);*/
	
	@OneToMany
	@JoinColumn(name="verwandte_filme_ids")
	private List<Film> verwandteFilme = new ArrayList<Film>(0);
	
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
	
	
	
	public Timestamp getUploaddatum() {
		return uploaddatum;
	}
	public void setUploaddatum(Timestamp uploaddatum) {
		this.uploaddatum = uploaddatum;
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
	
	
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genre) {
		this.genres = genre;
	}
	
	
	public Blob getTitelbild() {
		return titelbild;
	}
	public void setTitelbild(Blob titelbild) {
		this.titelbild = titelbild;
	}
	
	/*
	public List<Blob> getGallerie() {
		return gallerie;
	}
	public void setGallerie(List<Blob> gallerie) {
		this.gallerie = gallerie;
	}*/
	
	
	public List<Film> getVerwandteFilme() {
		return verwandteFilme;
	}
	public void setVerwandteFilme(List<Film> verwandteFilme) {
		this.verwandteFilme = verwandteFilme;
	}
	public List <Bewertung> getBewertungen() {
		return bewertungen;
	}
	public void setBewertungen(List <Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	} 

}
