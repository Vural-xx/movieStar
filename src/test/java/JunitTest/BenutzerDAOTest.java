package JunitTest;

import org.junit.Test;

import Database.BenutzerDAO;
import controller.BenutzerController;
import enums.Rolle;
import model.Benutzer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

public class BenutzerDAOTest {
	
	private String email;
	private String benutzername;
	private String passwort;
	private Benutzer benutzer;
	private Rolle rolle;
	private BenutzerDAO dao;
	
	@Before
	public void initialisieren(){
		email = "test@web.de";
		benutzername = "Horst1";
		passwort = "Test-1!";
		dao = new BenutzerDAO();
		benutzer = new Benutzer(email, benutzername, passwort);
		benutzerDatenGespeichert();
	}
	
	@Test
	public void benutzerDatenGespeichert(){
		dao.benutzerErstellen(benutzer);
		Assert.assertEquals("Erfolgreich registriert" , dao.getSqlStatus());
	}
	
	@Test
	public void benutzerDatenSuchen(){
		dao.benutzerSuchen(benutzer);
		Assert.assertEquals("Benutzer gefunden", dao.getSqlStatus());
	}
	
	@Test
	public void benutzerEMailVorhanden(){
		dao.benutzerVorhanden(benutzer, email);
		Assert.assertEquals("Benutzer vorhanden", dao.getSqlStatus());
	}
	
	@Test
	public void benutzerBenutzernameVorhanden(){
		dao.benutzerVorhanden(benutzer, benutzername);
		Assert.assertEquals("Benutzer vorhanden", dao.getSqlStatus());
	}
	
	@Test
	public void benutzerUpdaten(){
		dao.benutzerUpdate(benutzer);
		Assert.assertEquals("Erfolgreich geändert", dao.getSqlStatus());
	}
	
	@After
	public void benutzerLoeschen(){
		dao.benutzerLoeschen(benutzer);
		Assert.assertEquals("Erfolgreich gelöscht" , dao.getSqlStatus());
	}
}

