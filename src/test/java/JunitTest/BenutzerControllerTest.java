package JunitTest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

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
	private BenutzerController benCon;
	
	@Mock
    private FacesContext context;
	
	@Before
	public void initialisieren(){
		benCon = new BenutzerController();
		this.email = "test@web.de";
		this.benutzername = "Horst1";
		this.passwort = "Test-1!";
		
		context = Mockito.mock(FacesContext.class);
//		Mockito.when(mockFacesContext.getResponseWriter()).thenReturn(mockResponseWriter);
	}
	
	@Test
	public void regTest(){
		Assert.assertEquals("login" , benCon.registrieren(email, benutzername, passwort));
	}

}
