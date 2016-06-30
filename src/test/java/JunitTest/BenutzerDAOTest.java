package JunitTest;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import Database.BenutzerDAO;
import controller.BenutzerController;
import enums.Rechte;
import model.Benutzer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BenutzerDAOTest {
	
	private String email;
	private String benutzername;
	private String passwort;
	private Benutzer benutzer;
	private Rechte rolle;
	private BenutzerDAO dao;
	
	@Before
	public void initialisieren(){
		email = "test@web.de";
		benutzername = "Horst1";
		passwort = "Test-1!";
		dao = new BenutzerDAO();
		benutzer = new Benutzer(email, benutzername, passwort);
//		aBenutzerDatenGespeichert();
	}
	
	@Test
	public void aBenutzerDatenGespeichert(){
		dao.benutzerErstellen(benutzer);
		Assert.assertEquals("Erfolgreich registriert" , dao.getSqlStatus());
	}
	
	@Test
	public void bBenutzerDatenSuchen(){
		dao.benutzerSuchen(benutzer);
		Assert.assertEquals("Benutzer gefunden", dao.getSqlStatus());
	}
	
	@Test
	public void cBenutzerEMailVorhanden(){
		dao.benutzerVorhanden(benutzer, email);
		Assert.assertEquals("Benutzer vorhanden", dao.getSqlStatus());
	}
	
	@Test
	public void dBenutzerBenutzernameVorhanden(){
		dao.benutzerVorhanden(benutzer, benutzername);
		Assert.assertEquals("Benutzer vorhanden", dao.getSqlStatus());
	}
	
	@Test
	public void eBenutzerUpdaten(){
		dao.benutzerUpdate(benutzer);
		Assert.assertEquals("Erfolgreich geändert", dao.getSqlStatus());
	}
	
	@Test
	public void fBenutzerLoeschen(){
		dao.benutzerLoeschen(benutzer);
		Assert.assertEquals("Benutzer erfolgreich gelöscht" , dao.getSqlStatus());
	}
}

