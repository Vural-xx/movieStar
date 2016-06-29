package JunitTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Database.BenutzerDAO;
import Database.FilmDAO;
import controller.BenutzerController;
import model.Benutzer;
import model.Film;

public class FilmDAOTest {
	
	private String name;
	private String beschreibung;
	private String erscheinungsjahr;
	private String dauer;
	private Benutzer ersteller;
	private double sterne;
	private FilmDAO dao;
	private Film film;
	
	@Before
	public void initialisieren(){
		name = "X-Men2";
		beschreibung = "Actionfilm";
		erscheinungsjahr = "1998";
		film = new Film();
		film.setName(name);
		film.setErscheinungsjahr(erscheinungsjahr);
		film.setBeschreibung(beschreibung);
		dao = new FilmDAO();
		
	}
	

	@Test
	public void filmErstellenTest() {
		dao.filmErstellen(film);
		Assert.assertEquals("Film erfolgreich angelegt" , dao.getSqlStatus());
	}

}
