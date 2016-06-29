package JunitTest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sun.faces.config.InitFacesContext;

import Database.BenutzerDAO;
import controller.BenutzerController;
import enums.Rolle;
import model.Benutzer;

public class BenutzerControllerTest{
	
	private String email;
	private String benutzername;
	private String passwort;
	private String neuesPasswort;
	private BenutzerController benCon;
	private Benutzer benutzer;
	private String registriert;
	
	@Mock
    private FacesContext context;
	
	@Before
	public void initialisieren(){
		benCon = new BenutzerController();
		email = "test@web.de";
		benutzername = "Horst1";
		passwort = "Test-1!";
		neuesPasswort = "Test-123";
		benutzer = new Benutzer(email, benutzername, passwort);
		registriert =  benCon.registrieren(benutzer.getEmail(), benutzer.getBenutzername(), benutzer.getPasswort());
		regTest();
	}
	
	@Test
	public void regTest(){
		Assert.assertEquals("login" , registriert);
	}
	
	@Test
	public void logInTestEmail(){
		Assert.assertEquals("index", benCon.logIn(benutzer.getEmail(), benutzer.getPasswort()));
	}
//	
//	@Test
//	public void benutzerVerwaltenTest(){
//		Assert.assertTrue(benCon.benutzerVerwalten(email, benutzername, passwort, neuesPasswort));
//	}
//	
	
	@After
	public void loeschenTest(){
		Assert.assertEquals("geloescht", benCon.benutzerLoeschen(benutzer));
	}
}
