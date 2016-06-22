package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import Database.BenutzerDAO;
import interfaces.BenutzerFacade;
import model.Benutzer;

@ManagedBean(name="BenutzerController")
@SessionScoped
public class BenutzerController implements BenutzerFacade {

	BenutzerDAO benutzerDAO;
	@ManagedProperty(value="#{benutzer}")
	private Benutzer benutzer;
	String emailAdresse;
	String nutzername;
	private boolean emailVorhanden = false;
	private boolean nutzernameVorhanden = false;
	private boolean loggedIn = false;
	private boolean registrieren = false;
	private boolean datenÄndern = false;
	private String neues_passwort = null;
	@ManagedProperty(value="#{navigationController}")
	private NavigationController navigationController;
	
	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}
	
	public BenutzerController() {
		benutzerDAO = new BenutzerDAO();
	}
	
	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

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
		registrieren = benutzerDAO.benutzerErstellen(benutzer);
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
			this.benutzer = benutzer;
			return "index";
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login nicht möglich. Benutzername oder Passwort ist falsch", null));
			return "login";
		}
	}
	
	public String kontakt(){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Vielen Dank. Ihre Nachricht wurde erfolgreich übermittelt", null));
		return "kontakt";
		
	}

	public String logOut() {
		// TODO Auto-generated method stub
		setLoggedIn(false);
		benutzer = null;
		return navigationController.toIndex();

	}

	public void passwortVergessen(String email, String benutzername, String passwort) {
		// TODO Auto-generated method stub

	}

	
	public void benutzerVerwalten(String email, String benutzername, String passwort, String neues_passwort) {
		// TODO Auto-generated method stub
		Benutzer benutzer = benutzerDAO.benutzerSuchen(new Benutzer(email,benutzername, passwort));
		if(benutzer == null){
			datenÄndern = false;
			FacesMessage msg = new FacesMessage("Änderung war nicht erfolgreich");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR );
		}else{
			datenÄndern = benutzer.getPasswort().equals(passwort);
		}
		if (datenÄndern) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Die Änderung war erfolgreich!", null));
			benutzer.setEmail(email);
			benutzer.setBenutzername(benutzername);
			benutzer.setPasswort(neues_passwort);

		}else{
			FacesMessage msg = new FacesMessage("Änderung war nicht erfolgreich");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR );

		}
		benutzerDAO.benutzerUpdate(benutzer);

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
