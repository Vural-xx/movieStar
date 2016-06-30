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
import model.Bewertung;
import model.Film;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilmDAOTest {
	
	private String name;
	private String beschreibung;
	private String erscheinungsjahr;
	private Bewertung bewertung;
	private double sterne;
	private FilmDAO filmDao;
	private Film film;
	
	@Before
	public void initialisieren(){
		filmDao = new FilmDAO();
		name = "X-Men2";
		beschreibung = "Actionfilm";
		erscheinungsjahr = "1998";
		film = new Film();
		bewertung = new Bewertung();
		sterne = 3.0;
		bewertung.setSterne(sterne);
		film.setName(name);
		film.setUploaddatum(new Date());
		film.setErscheinungsjahr(erscheinungsjahr);
		film.setBeschreibung(beschreibung);
		film.setGenre(Genre.ACTION);
	}
	

	@Test
	public void aFilmErstellenTest() {
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
	public void dNeusteFilmeTest(){
		Assert.assertFalse(filmDao.neusteFilme() == null);
	}
	
	@Test
	public void eTop10Test(){
		Assert.assertFalse(filmDao.top10() == null);
	}
	
	@Test
	public void fAlleFilmeTest(){
		Assert.assertFalse(filmDao.alleFilme() == null);
	}

	@Test
	public void gFilmBewertenTest(){
		filmDao.bewerteFilm(bewertung, film);
		Assert.assertEquals("Update Film und erstelle Bewertung", filmDao.getSqlStatus());
	}
	 
	@Test
	public void hFilmLoeschen(){
		filmDao.filmLoeschen(film);
		Assert.assertEquals("Film erfolgreich gelöscht", filmDao.getSqlStatus());
	}
}
