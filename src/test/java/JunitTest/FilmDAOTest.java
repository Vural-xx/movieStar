package JunitTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Database.BenutzerDAO;
import Database.FilmDAO;
import controller.BenutzerController;
import enums.Genre;
import model.Benutzer;
import model.Film;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilmDAOTest {
	
	private String name;
	private String beschreibung;
	private String erscheinungsjahr;
	//private Benutzer ersteller;
	private FilmDAO filmDao;
	//private BenutzerDAO benutzerDAO;
	private Film film;
	
	@Before
	public void initialisieren(){
		filmDao = new FilmDAO();
		//benutzerDAO = new BenutzerDAO();
		name = "X-Men2";
		beschreibung = "Actionfilm";
		erscheinungsjahr = "1998";
		film = new Film();
//		ersteller = new Benutzer();
//		ersteller.setEmail("jannis@jannis.de");
//		ersteller.setBenutzername("Ja");
//		ersteller.setPasswort("Test134+");
		film.setName(name);
		//film.setErsteller(ersteller);
		film.setUploaddatum(new Date());
		film.setErscheinungsjahr(erscheinungsjahr);
		film.setBeschreibung(beschreibung);
		film.setGenre(Genre.ACTION);
	}
	

	@Test
	public void aFilmErstellenTest() {
		//benutzerDAO.benutzerErstellen(ersteller);
		filmDao.filmErstellen(film);
		Assert.assertEquals("Film erfolgreich angelegt" , filmDao.getSqlStatus());
	}
	
	@Test
	public void bFilmUpdateTest(){
		film.setBeschreibung("guter Actionfilm");
		filmDao.filmUpdate(film);
		Assert.assertEquals("Film update erfolgreich", filmDao.getSqlStatus());
	}
	
	@Test
	public void cFilmSuchenTest(){
		filmDao.filmSuchen("X-Men2");
		Assert.assertEquals("Film suche erfolgreich", filmDao.getSqlStatus());
	}

	 
	@Test
	public void eFilmLoeschen(){
		//benutzerDAO.benutzerLoeschen(ersteller);
		filmDao.filmLoeschen(film);
		//Assert.assertEquals("Benutzer erfolgreich gelöscht" , benutzerDAO.getSqlStatus());
		Assert.assertEquals("Film erfolgreich gelöscht", filmDao.getSqlStatus());
	}
}
