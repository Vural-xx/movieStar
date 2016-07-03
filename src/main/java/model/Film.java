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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import enums.Genre;

/**
 * @author MacBook
 * Klasse Film
 *
 */
/**
 * @author MacBook
 *
 */
@Entity
@Table(name = "Filme")
public class Film implements Serializable{

	private static final long serialVersionUID = -550197280185627795L;
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "beschreibung", length = 512)
	private String beschreibung;
	
	@Id
	@Column(name = "erscheinungsjahr")
	@Min(1895)
	@Max(2020)
	private int erscheinungsjahr;
	
	@Column(name = "dauer")
	private int dauer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ersteller")
	private Benutzer ersteller;
	
	@Formula("(SELECT avg(b.sterne) FROM Filme f left join Bewertungen b  on f.name = b.film_name where f.name = name AND f.erscheinungsjahr = b.film_erscheinungsjahr)")
	private Double sterne;
	
	@Column(name="uploaddatum")
	private Date uploaddatum;
		
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "film_mitwirkende", joinColumns = { 
			@JoinColumn(name = "film_name", referencedColumnName="name"), @JoinColumn(name = "film_erscheinungsjahr", referencedColumnName="erscheinungsjahr")}, 
			inverseJoinColumns = { @JoinColumn(name = "mitwirkende_name") })
	private List<Mitwirkende> mitwirkende = new ArrayList<Mitwirkende>(0);
	
	@OneToMany
	@JoinColumns({
	       @JoinColumn(name="film_name", referencedColumnName="name"),
	       @JoinColumn(name="film_erscheinungsjahr", referencedColumnName="erscheinungsjahr")
	})
	private List<Kommentar> kommentare;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns({
	       @JoinColumn(name="film_name", referencedColumnName="name"),
	       @JoinColumn(name="film_erscheinungsjahr", referencedColumnName="erscheinungsjahr")
	})
	private List <Bewertung> bewertungen = new ArrayList<Bewertung>(0);
	
	@ElementCollection(targetClass = Genre.class)
	@Column(name = "genres", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Genre> genres;
	
	@Column(name = "genres", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genre genre;

	@Column(name="titelbild")
	@Lob
	private Blob titelbild;
	
	@OneToMany
	@JoinColumns({
	       @JoinColumn(name="verwandter_film_name", referencedColumnName="name"),
	       @JoinColumn(name="verwandter_film_erscheinungsjahr", referencedColumnName="erscheinungsjahr")
	})
	private List<Film> verwandteFilme = new ArrayList<Film>(0);
	
	/**
	 * Getter Filmname
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter Filmname
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter Genre
	 * @return
	 */
	public Genre getGenre() {
		return genre;
	}
	
	/**
	 * Setter Genre
	 * @param genre
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	/**
	 * Getter Filmbeschreibung
	 * @return
	 */
	public String getBeschreibung() {
		return beschreibung;
	}
	
	/**
	 * Setter Filmbeschreibung
	 * @param beschreibung
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	
	/**
	 * Getter Erscheinungsjahr
	 * @return
	 */
	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}
	
	/**
	 * Setter Erscheinungsjahr
	 * @param erscheinungsjahr
	 */
	public void setErscheinungsjahr(int erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}
	
	/**
	 * Getter Uploaddatum
	 * @return
	 */
	public Date getUploaddatum() {
		return uploaddatum;
	}
	
	/**
	 * Setter Uploaddatum
	 * @param uploaddatum
	 */
	public void setUploaddatum(Date uploaddatum) {
		this.uploaddatum = uploaddatum;
	}
	
	/**
	 * Getter Filmdauer
	 * @return
	 */
	public int getDauer() {
		return dauer;
	}
	
	/**Setter Filmdauer
	 * @param dauer
	 */
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	/**
	 * Getter Filmersteller
	 * @return
	 */
	public Benutzer getErsteller() {
		return ersteller;
	}
	
	/**
	 * Setter Filmersteller
	 * @param ersteller
	 */
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}

	/**
	 * Getter Sterne
	 * @return
	 */
	public Double getSterne() {
		if(sterne == null){
			return 0.0;
		}else{
			return sterne;
		}
	}
	/**
	 * Setter Sterne
	 * @param sterne
	 */
	public void setSterne(Double sterne) {
		this.sterne = sterne;
	}
	
	/**
	 * Getter Mitwirkende
	 * @return
	 */
	public List<Mitwirkende> getMitwirkende() {
		return mitwirkende;
	}
	
	/**
	 * Setter Mitwirkende
	 * @param mitwirkende
	 */
	public void setMitwirkende(List<Mitwirkende> mitwirkende) {
		this.mitwirkende = mitwirkende;
	}
	
	
	/**
	 * Getter Kommentare
	 * @return
	 */
	public List<Kommentar> getKommentare() {
		return kommentare;
	}
	
	/**
	 * Setter Kommentare
	 * @param kommentare
	 */
	public void setKommentare(List<Kommentar> kommentare) {
		this.kommentare = kommentare;
	}
	
	
	/**
	 * Getter Genre Liste 
	 * @return
	 */
	public List<Genre> getGenres() {
		return genres;
	}
	
	/**
	 * Setter Genre Liste
	 * @param genre
	 */
	public void setGenres(List<Genre> genre) {
		this.genres = genre;
	}
	
	
	/**
	 * Getter Titelbild
	 * @return
	 */
	public Blob getTitelbild() {
		return titelbild;
	}
	
	/**
	 * Setter Titelbild
	 * @param titelbild
	 */
	public void setTitelbild(Blob titelbild) {
		this.titelbild = titelbild;
	}
		
	/**
	 * Getter Verwandte Filme
	 * @return
	 */
	public List<Film> getVerwandteFilme() {
		return verwandteFilme;
	}
	
	/**
	 * Setter verwandte Filme
	 * @param verwandteFilme
	 */
	public void setVerwandteFilme(List<Film> verwandteFilme) {
		this.verwandteFilme = verwandteFilme;
	}
	
	/**
	 * Getter Bewertung
	 * @return
	 */
	public List <Bewertung> getBewertungen() {
		return bewertungen;
	}
	
	/**
	 * Setter Filmbewertung
	 * @param bewertungen
	 */
	public void setBewertungen(List <Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	} 
	
	/**
	 * Getter DatumFormat
	 * @return
	 */
	public String getFormatDatum(){
		SimpleDateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
		//System.out.println(dt1.format(uploaddatum));
		return dt1.format(uploaddatum);
		
	}

}
