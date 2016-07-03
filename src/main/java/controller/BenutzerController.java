package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import Database.BenutzerDAO;
import enums.Rechte;
import interfaces.BenutzerFacade;
import model.Benutzer;

/**
 * @author MacBook
 * BenutzerController zur Verknüpfung der Benutzeransicht und der Benutzerdatenbank
 *
 */
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
	private boolean admin = false;
	private boolean registrieren = false;
	private boolean datenÄndern = false;
	private String neues_passwort = null;
	@ManagedProperty(value="#{navigationController}")
	private NavigationController navigationController;

	
	/**
	 * Konstruktor von BenutzerController
	 */
	public BenutzerController() {
		benutzerDAO = new BenutzerDAO();
	}
	
	
	/**
	 * Getter von NavigationController
	 * @return NavigationController
	 */
	public NavigationController getNavigationController() {
		return navigationController;
	}

	/**
	 * Setter von NavigationController
	 * @param navigationController
	 */
	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}
	
	/**
	 * Getter von Benutzer
	 * @return benutzer
	 */
	public Benutzer getBenutzer() {
		return benutzer;
	}

	/**
	 * Setter von Benutzer
	 * @param benutzer
	 */
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	/**
	 * boolean zur Prüfung, ob Email bereits vorhanden ist
	 * @return emailVorhanden
	 */
	public boolean isEmailVorhanden() {
		return emailVorhanden;
	}

	/**
	 * Setzt Status, das EmailVorhanden ist
	 * @param emailVorhanden
	 */
	public void setEmailVorhanden(boolean emailVorhanden) {
		this.emailVorhanden = emailVorhanden;
	}

	/**
	 * boolean zur Prüfung, ob Nutzername bereits vorhanden ist
	 * @return nutzernameVorhanden
	 */
	public boolean isNutzernameVorhanden() {
		return nutzernameVorhanden;
	}

	/**
	 * Setzt Status, das Nutzname vorhanden ist
	 * @param nutzernameVorhanden
	 */
	public void setNutzernameVorhanden(boolean nutzernameVorhanden) {
		this.nutzernameVorhanden = nutzernameVorhanden;
	}

	/**
	 * Getter von Nutzername
	 * @return nutzername
	 */
	public String getNutzername() {
		return nutzername;
	}

	/**
	 * Setter von Nutzername
	 * @param nutzername
	 */
	public void setNutzername(String nutzername) {
		this.nutzername = nutzername;
	}

	/**
	 * Getter von EmailAdresse
	 * @return emailAdresse
	 */
	public String getEmailAdresse() {
		return emailAdresse;
	}

	/**
	 * Setter von EmailAdresse;
	 * @param emailAdresse
	 */
	public void setEmailAdresse(String emailAdresse) {
		this.emailAdresse = emailAdresse;
	}
	
	


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public String registrieren(String email, String benutzername, String passwort) {
		Benutzer benutzer = new Benutzer(email, benutzername, passwort);
		registrieren = benutzerDAO.benutzerErstellen(benutzer);
		if (registrieren == true) {
			if(FacesContext.getCurrentInstance() == null){
			}else{
				System.out.println(FacesContext.getCurrentInstance());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Die Registrierung war erfolgreich!", null));
			}
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
			if(FacesContext.getCurrentInstance() == null){
				
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login nicht möglich. Benutzername oder Passwort ist falsch", null));
			}
			
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

	
	public String benutzerVerwalten(String email, String benutzername, String passwort, String neues_passwort) {
		// TODO Auto-generated method stub
		Benutzer benutzer = benutzerDAO.benutzerSuchen(new Benutzer(email,benutzername, passwort));
		if(benutzer == null){
			datenÄndern = false;
		}else{
			datenÄndern = benutzer.getPasswort().equals(passwort);
		}
		if (datenÄndern) {
				if(FacesContext.getCurrentInstance() == null){
				
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Die Änderung war erfolgreich!", null));
			}

			benutzer.setEmail(email);
			benutzer.setBenutzername(benutzername);
			benutzer.setPasswort(neues_passwort);
			benutzerDAO.benutzerUpdate(benutzer);

		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Die Änderung war nicht erfolgreich!", null));
		}
		
		return "benutzerVerwalten";
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

	/**
	 * boolean zur Prüfung, ob der Nutzer eingeloggt ist
	 * @return loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Setzt Status, das Nutzer eingeloggt ist
	 * @param loggedIn
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	@Override
	public boolean benutzerLoeschen(Benutzer benutzer) {
		return benutzerDAO.benutzerLoeschen(benutzer);
	}
}
