package JunitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import controller.BenutzerController;
import model.Benutzer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BenutzerControllerTest{
	
	private String email;
	private String benutzername;
	private String passwort;
	private String neuesPasswort;
	private BenutzerController benCon;
	private Benutzer benutzer;
	
	@Before
	public void initialisieren(){
		benCon = new BenutzerController();
		email = "test@web.de";
		benutzername = "Horst1";
		passwort = "Test-1!";
		neuesPasswort = "Test-123";
		benutzer = new Benutzer(email, benutzername, passwort);
		
	}
	
	@Test
	public void aRegTest(){
		Assert.assertEquals("login" , benCon.registrieren(benutzer.getEmail(), benutzer.getBenutzername(), benutzer.getPasswort()));
	}
	
	@Test
	public void bLogInTestEmail(){
		Assert.assertEquals("index", benCon.logIn(benutzer.getEmail(), benutzer.getPasswort()));
	}
	
	
	@Test
	public void cBenutzerVerwaltenTest(){
		benutzer.setBenutzername("Horst");
		Assert.assertEquals("benutzerVerwalten", benCon.benutzerVerwalten(benutzer.getEmail(), benutzer.getBenutzername(), benutzer.getPasswort(), neuesPasswort));
		
	}
	
	
	@Test
	public void dEmailInDBVorhanden(){
		Assert.assertFalse(benCon.getEmailInDBVorhanden());
	}
	
	@After
	public void eLoeschenTest(){
		benCon.benutzerLoeschen(benutzer);
	}

}
