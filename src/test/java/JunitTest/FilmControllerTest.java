package JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Database.BenutzerDAO;
import Database.FilmDAO;
import controller.BenutzerController;
import controller.FilmController;
import enums.FilmAuswahl;
import enums.Genre;
import model.Benutzer;
import model.Film;
import model.Filter;
import model.Mitwirkende;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilmControllerTest {

	private String name;
	private String beschreibung;
	private int erscheinungsjahr;
	private Film film;
	private FilmController fiCon;
	private Benutzer ersteller;
	private BenutzerController benCon;
	private Filter filter;
	private List<Film> filme;
	private Mitwirkende mitwirkender;
	private List<Mitwirkende> mitwirkende;
	
	@Before
	public void initialisieren(){
		fiCon = new FilmController();
		benCon = new BenutzerController();
		filter = new Filter();
		filme = new ArrayList<Film>();
		name = "X-Men2";
		beschreibung = "Actionfilm";
		erscheinungsjahr = 1998;
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
		filme.add(film);
	}
	
	@Test
	public void aFilmErstellenTest() {
		Assert.assertEquals("/filmListe.xhtml", fiCon.filmErstellen(film));
	}
	
	@Test
	public void bUpdateFilmTest(){
		Assert.assertEquals("/filmListe.xhtml", fiCon.filmUpdate(film));
	}
	
	@Test
	public void cFilmSuchen(){
		Assert.assertEquals("/such.xhtml", fiCon.filmSuchen("X-Men 2"));
	}
	

	@Test
	public void eFilmBewertenTest() {
		Assert.assertTrue(fiCon.filmBewerten((new Double(1.0)).longValue(), 5.0));

	}

	@Test
	public void fFilmKommentierenTest() {
		Assert.assertTrue(fiCon.filmKommentieren((new Double(1.0)).longValue(), "Der Film ist der Hammer"));

	}

	
	@Test
	public void hNeusteFilmeTest() {
		Assert.assertEquals("/such.xhtml", fiCon.neusteFilme());
	}
	
	@Test
	public void iTop10Test() {
		Assert.assertFalse(fiCon.top10() == null);
	}
	
	@Test
	public void jAlleFilmeTest() {
		Assert.assertEquals("/alleFilme.xhtml", fiCon.alleFilme());
	}
	
	@Test
	public void kFilmDerWocheTest(){
		Assert.assertTrue(fiCon.filmDerWoche(filme) != null);
	}
	
	@Test
	public void lSortiereFilmTest(){
		fiCon.setFilme(filme);
		Assert.assertEquals("/alleFilme.xhtml", fiCon.sortiereFilm("NAMEAZ"));
	}
	
	@Test
	public void mGetMitwirkendeTest(){
		fiCon.setFilm(film);
		Assert.assertTrue(fiCon.getMitwirkende() != null);
	}
	
	@Test
	public void nBewerteFilmTest(){
		Assert.assertEquals("/film.xhtml", fiCon.bewerteFilm());
	}
	
	@Test
	public void oFilmLoeschen(){
		Assert.assertTrue(fiCon.filmLoeschen(film));
	}
}
