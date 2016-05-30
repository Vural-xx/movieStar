package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import Database.SQLDatabase;
import interfaces.BenutzerFacade;
import model.Benutzer;

@ManagedBean(name="BenutzerController")
public class BenutzerController implements BenutzerFacade {

	SQLDatabase sqlDatabase = new SQLDatabase();
	String emailAdresse;
	String nutzername;
	private boolean emailVorhanden = false;
	private boolean nutzernameVorhanden = false;

	public boolean isEmailVorhanden() {
		return emailVorhanden;
	}

	public void setEmailVorhanden(boolean emailVorhanden) {
		this.emailVorhanden = emailVorhanden;
	}

	public boolean isNutzernameVorhanden() {
		return nutzernameVorhanden;
	}

	public void setNutzernameVorhanden(boolean nutzernameVorhanden) {
		this.nutzernameVorhanden = nutzernameVorhanden;
	}

	public String getNutzername() {
		return nutzername;
	}

	public void setNutzername(String nutzername) {
		this.nutzername = nutzername;
	}

	public String getEmailAdresse() {
		return emailAdresse;
	}

	public void setEmailAdresse(String emailAdresse) {
		this.emailAdresse = emailAdresse;
	}

	public String registrieren(String email, String benutzername, String passwort) {
		Benutzer benutzer = new Benutzer(email, benutzername, passwort);
		boolean registrieren = sqlDatabase.benutzerErstellen(benutzer);
		System.out.println(nutzername);
		if (registrieren = true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Die Registrierung war erfolgreich!", null));
			return "login";
		}
		return " ";

	}

	public String logIn(String logIn, String passwort) {
		Benutzer benutzer = sqlDatabase.benutzerSuchen(new Benutzer(logIn, passwort));
		if (benutzer != null) {
			return "index";
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
		// Benutzerdaten suchen, überprüfung, ob Passwort richtig ist, dann
		// überschreiben

		// Benutzer benutzer = sqlDatabase.benutzerSuchen(email, benutzername,
		// passwort);
		// if(benutzer !=null){
		// alten Benutzer löschen, nur wie? bzw Benutzerdaten überschreiben ???
		// boolean benutzerExistiert = sqlDatabase.benutzerErstellen(benutzer);
		// }

	}

	@Override
	public void benutzerBlockieren(String benutzername, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void kommentareLoeschen(Long KID) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getEmailInDBVorhanden() {
		Benutzer benutzer = new Benutzer(emailAdresse, "email");
		emailVorhanden = sqlDatabase.benutzerVorhanden(benutzer, "E-mail");
		return emailVorhanden;
	}

	@Override
	public boolean getNutzernameInDBVorhanden() {
		Benutzer benutzer = new Benutzer(nutzername);
		nutzernameVorhanden = sqlDatabase.benutzerVorhanden(benutzer, "Benutzername");
		return nutzernameVorhanden;
	}

}
