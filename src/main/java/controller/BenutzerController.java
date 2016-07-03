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
	
	/**
	 * BenutzerDAO benutzerDAO
	 */
	private BenutzerDAO benutzerDAO;
	
	/**
	 * Benutzer benutzer
	 */
	@ManagedProperty(value="#{benutzer}")
	private Benutzer benutzer;
	/**
	 * String emailAdresse
	 */
	private String emailAdresse;
	
	/**
	 * String nutzername
	 */
	private String nutzername;
	/**
	 * boolean loggedIn
	 */
	private boolean loggedIn = false;
	/**
	 * boolean admin
	 */
	private boolean admin = false;
	/**
	 * boolean registrieren
	 */
	private boolean registrieren = false;
	/**
	 * boolean datenÄndern
	 */
	private boolean datenÄndern = false;
	/**
	 * String neues_passwort
	 */
	private String neues_passwort = null;
	
	/**
	 * NavigationController navigationController
	 */
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
	
	
	/**
	 * getter isAdmin
	 * @return
	 */

	public boolean isAdmin() {
		return admin;
	}
	
	/**
	 * setter Admin
	 * @param admin
	 */
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * registrieren prüft ob der benutzer schon existiert. Existiert kein Benutzer wird einer erstellt
	 */
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
	
	/**
	 * Benutzer wird gesucht. Wird benutzer gefunden logged der User sich ein
	 */

	public String logIn(String logIn, String passwort) {
		System.out.println("test");
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
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
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
		return benutzerDAO.benutzerVorhanden(benutzer, "E-mail");
	}

	@Override
	public boolean getNutzernameInDBVorhanden() {
		Benutzer benutzer = new Benutzer(nutzername);
		return benutzerDAO.benutzerVorhanden(benutzer, "Benutzername");
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
	
	public String profilVerwaltungVorbereiten(){
		this.emailAdresse = null;
		this.nutzername = null;
		return navigationController.toBenutzerVerwalten();
	}
}
