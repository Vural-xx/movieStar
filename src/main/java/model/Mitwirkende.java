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

@Entity
@Table(name = "Mitwirkende")
public class Mitwirkende implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3185319011120312486L;
	
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
	public List<Film> getFilme() {
		return filme;
	}
	public void setFilme(List<Film> filme) {
		this.filme = filme;
	}
	
	
}
