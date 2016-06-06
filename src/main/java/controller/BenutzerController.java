package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import Database.BenutzerDAO;
import interfaces.BenutzerFacade;
import model.Benutzer;

@ManagedBean(name="BenutzerController")
@SessionScoped
public class BenutzerController implements BenutzerFacade {

	BenutzerDAO benutzerDAO = new BenutzerDAO();
	String emailAdresse;
	String nutzername;
	private boolean emailVorhanden = false;
	private boolean nutzernameVorhanden = false;
	private boolean loggedIn = false;

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
		boolean registrieren = benutzerDAO.benutzerErstellen(benutzer);
		System.out.println(nutzername);
		if (registrieren = true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Die Registrierung war erfolgreich!", null));
			return "login";
		}
		return " ";

	}

	public String logIn(String logIn, String passwort) {
		Benutzer benutzer = benutzerDAO.benutzerSuchen(new Benutzer(logIn, passwort));
		if (benutzer != null) {
			setLoggedIn(true);
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
		emailVorhanden = benutzerDAO.benutzerVorhanden(benutzer, "E-mail");
		return emailVorhanden;
	}

	@Override
	public boolean getNutzernameInDBVorhanden() {
		Benutzer benutzer = new Benutzer(nutzername);
		nutzernameVorhanden = benutzerDAO.benutzerVorhanden(benutzer, "Benutzername");
		return nutzernameVorhanden;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
