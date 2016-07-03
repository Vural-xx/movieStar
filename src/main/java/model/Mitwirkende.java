package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import enums.FilmRolle;

/**
 * @author MacBook
 * Klasse Mitwirkende
 *
 */
@Entity
@Table(name = "Mitwirkende")
public class Mitwirkende implements Serializable {

	private static final long serialVersionUID = -3185319011120312486L;
	
	/**
	 * Kontruktor
	 */
	public Mitwirkende(){
		
	}
	
	public Mitwirkende(String name){
		this.name = name;
	}

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="vorname")
	private String vorname;
	
	@Column(name = "film_rolle")
	@Enumerated(EnumType.STRING)
	private FilmRolle filmRolle;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "mitwirkende")
	private List<Film> filme = new ArrayList<Film>(0); 
	
	/**
	 * Getter Name Mitwirkender
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter Name Mitwirkender
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter Vorname Mitwirkender 
	 * @return
	 */
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Setter Vorname Mitwirkender
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	/**
	 * Getter FilmRolle
	 * @return
	 */
	public FilmRolle getFilmRolle() {
		return filmRolle;
	}
	
	/**
	 * Setter FilmRolle
	 * @param filmRolle
	 */
	public void setFilmRolle(FilmRolle filmRolle) {
		this.filmRolle = filmRolle;
	}
	
	/**
	 * Getter Film Liste
	 * @return
	 */
	public List<Film> getFilme() {
		return filme;
	}
	
	/**
	 * Setter Film Liste
	 * @param filme
	 */
	public void setFilme(List<Film> filme) {
		this.filme = filme;
	}

	@Override
	public String toString() {
		
		return vorname+" "+name;
	}
	
	
}
