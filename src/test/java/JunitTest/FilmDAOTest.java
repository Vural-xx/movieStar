package JunitTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Database.BenutzerDAO;
import Database.FilmDAO;
import controller.BenutzerController;
import enums.Genre;
import model.Benutzer;
import model.Film;

public class FilmDAOTest {
	
	private String name;
	private String beschreibung;
	private String erscheinungsjahr;
	private Benutzer ersteller;
	private FilmDAO filmDao;
	private BenutzerDAO benutzerDAO;
	private Film film;
	
	@Before
	public void initialisieren(){
		filmDao = new FilmDAO();
		benutzerDAO = new BenutzerDAO();
		name = "X-Men2";
		beschreibung = "Actionfilm";
		erscheinungsjahr = "1998";
		film = new Film();
		ersteller = new Benutzer();
		ersteller.setEmail("jannis@jannis.de");
		ersteller.setBenutzername("Ja");
		ersteller.setPasswort("Test134+");
		film.setName(name);
		film.setErsteller(ersteller);
		film.setUploaddatum(new Date());
		film.setErscheinungsjahr(erscheinungsjahr);
		film.setBeschreibung(beschreibung);
		film.setGenre(Genre.ACTION);
		
		
	}
	

	@Test
	public void filmErstellenTest() {
		benutzerDAO.benutzerErstellen(ersteller);
		filmDao.filmErstellen(film);
		Assert.assertEquals("Film erfolgreich angelegt" , filmDao.getSqlStatus());
	}
	
//	@Test
//	public void filmUpdateTest(){
//		filmDao.filmUpdate(film);
//		Assert.assertEquals("Film update erfolgreich", filmDao.getSqlStatus());
//	}

	//After benutzer und Film löschen ! 
	@After
	public void benutzerUndFilmLoeschen(){
		benutzerDAO.benutzerLoeschen(ersteller);
		Assert.assertEquals("Erfolgreich gelöscht" , benutzerDAO.getSqlStatus());
	}
}
