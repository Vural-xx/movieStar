package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Database.SQLDatabase;
import interfaces.BenutzerFacade;
import model.Benutzer;

@ManagedBean(name="BenutzerController")
public class BenutzerController implements BenutzerFacade {
	
		SQLDatabase sqlDatabase = new SQLDatabase();
	
	public String registrieren(String email, String benutzername, String passwort) {
		Benutzer benutzer = new Benutzer(email,benutzername,passwort);
		boolean registrieren = sqlDatabase.benutzerErstellen(benutzer);
		if(registrieren = true){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Die Registrierung war erfolgreich!", null));
			return "login";
		}
		return " ";
		
	}
	

	public String logIn(String logIn, String passwort) {
		Benutzer benutzer = sqlDatabase.benutzerSuchen(new Benutzer(logIn,passwort));
		if(benutzer != null){
			return "regAusgabe";
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
