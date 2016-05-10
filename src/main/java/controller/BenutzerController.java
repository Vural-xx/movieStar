package controller;

import javax.faces.bean.ManagedBean;

import Database.SQLDatabase;
import interfaces.BenutzerFacade;
import model.Benutzer;

@ManagedBean(name="BenutzerController")
public class BenutzerController implements BenutzerFacade {
	
		SQLDatabase sqlDatabase = new SQLDatabase();
	
	public void registrieren(String email, String benutzername, String passwort) {
		Benutzer benutzer = new Benutzer(email,benutzername,passwort);
		sqlDatabase.benutzerSuchen(benutzer);
		
	}
	

	public String logIn(String logIn, String passwort) {
		Benutzer benutzer = sqlDatabase.benutzerSuchen(new Benutzer(logIn,passwort));
		if(benutzer != null){
			return "success";
		}
		return "false";
	}

	public void logOut() {
		// TODO Auto-generated method stub
		
	}

	public void passwortVergessen(String email, String benutzername, String passwort) {
		// TODO Auto-generated method stub
		
	}
	// Update Benutzer
	public void benutzerVerwalten(String email, String benutzername, String passwort) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void benutzerBlockieren(String benutzername, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kommentareLoeschen(Long KID) {
		// TODO Auto-generated method stub
		
	}
	
	

}
