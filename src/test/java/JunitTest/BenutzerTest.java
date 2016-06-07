package JunitTest;

import org.junit.Test;

import Database.BenutzerDAO;
import controller.BenutzerController;
import enums.Rolle;
import model.Benutzer;

import org.junit.Assert;
import org.junit.Before;

public class BenutzerTest {
	
	private String email;
	private String benutzername;
	private String passwort;
	private Benutzer benutzer;
	private Rolle rolle;
	@Before
	public void regDaten(){
		email = "test@web.de";
		benutzername = "Horst1";
		passwort = "Test-1!";
		
	}
	
	@Test
	public void regDatenGespeichert(){
		//Fixture erzeugen (Benutzerdaten hinzufügen)
		//Eingabe erzeugen
		//Test ausführen (Benutzerdaten speichern)
		//Verhalten überprüfen (Prüfung Benutzerdaten vorhanden)
		//Assert.assertTrue(" Nachricht Test ok", SQLDatabase.benutzerVorhanden(benutzer, email));
		//Aufräumen	
	}

}

