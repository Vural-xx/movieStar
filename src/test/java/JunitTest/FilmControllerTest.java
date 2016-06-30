package JunitTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Database.BenutzerDAO;
import Database.FilmDAO;
import controller.BenutzerController;
import controller.FilmController;
import enums.Genre;
import model.Benutzer;
import model.Film;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilmControllerTest {

	private String name;
	private String beschreibung;
	private String erscheinungsjahr;
	private Film film;
	private FilmController fiCon;
	private Benutzer ersteller;
	private BenutzerController benCon;
	
	
	@Before
	public void initialisieren(){
		fiCon = new FilmController();
		benCon = new BenutzerController();
		name = "X-Men2";
		beschreibung = "Actionfilm";
		erscheinungsjahr = "1998";
		ersteller = new Benutzer();
		ersteller.setEmail("jannis@jannis.de");
		ersteller.setBenutzername("Ja");
		ersteller.setPasswort("Test134+");
		benCon.setBenutzer(ersteller);
		fiCon.setBenutzerController(benCon);
		film = new Film();
		film.setName(name);
		film.setErsteller(ersteller);
		film.setUploaddatum(new Date());
		film.setErscheinungsjahr(erscheinungsjahr);
		film.setBeschreibung(beschreibung);
		film.setGenre(Genre.ACTION);
	}
	
	@Test
	public void aFilmErstellenTest() {
		Assert.assertEquals("/filmListe.xhtml", fiCon.filmErstellen(film));
	}
	
	@Test
	public void fFilmLoeschen(){
		Assert.assertTrue(fiCon.filmLoeschen(film));
	}
}
