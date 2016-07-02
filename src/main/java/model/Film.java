package model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

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
	
	@Column(name = "beschreibung", length = 512)
	private String beschreibung;
	
	@Column(name = "erscheinungsjahr")
	private String erscheinungsjahr;
	
	@Column(name = "dauer")
	private String dauer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ersteller")
	private Benutzer ersteller;
	
	@Formula("(SELECT avg(b.sterne) FROM Filme f left join Bewertungen b  on f.name = b.film_id where f.name = name)")
	private Double sterne;
	
	private Date uploaddatum;
		
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "film_mitwirkende", joinColumns = { 
			@JoinColumn(name = "film_name") }, 
			inverseJoinColumns = { @JoinColumn(name = "mitwirkende_name") })
	private List<Mitwirkende> mitwirkende = new ArrayList<Mitwirkende>(0);
	
	@OneToMany
	@JoinColumn(name = "film_id")
	private List<Kommentar> kommentare;
	
	@OneToMany
	@JoinColumn(name = "film_id")
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
	
	
	
	public Date getUploaddatum() {
		return uploaddatum;
	}
	public void setUploaddatum(Date uploaddatum) {
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
	
	

	public Double getSterne() {
		if(sterne == null){
			return 0.0;
		}else{
			return sterne;
		}
	}
	public void setSterne(Double sterne) {
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
	
	public String getFormatDatum(){
		SimpleDateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
		//System.out.println(dt1.format(uploaddatum));
		return dt1.format(uploaddatum);
		
	}

}
