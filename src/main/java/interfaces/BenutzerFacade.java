package interfaces;

import javax.faces.event.AjaxBehaviorEvent;

import model.Benutzer;

/**
 * @author MacBook
 *
 */
public interface BenutzerFacade {
	
	/**
	 * Methode zur Registrierung eines Benutzers  
	 * @param email
	 * @param benutzername
	 * @param passwort
	 * @return benutzer
	 */
	public String registrieren(String email, String benutzername, String passwort);

	/**
	 * Methode zum Login eines Benutzers
	 * @param logIn
	 * @param passwort
	 * @return
	 */
	public String logIn(String logIn, String passwort);
	
	/**
	 * Methode zum Logout eines Benutzers
	 * @return
	 */
	public String logOut();
	
	/**
	 * Methode, wenn der Benutzer sein Passwort vergessen hat
	 * @param email
	 * @param benutzername
	 * @param passwort
	 */
	public void passwortVergessen(String email, String benutzername, String passwort);
	
	/**
	 * Methode um die Benutzerdaten zu ändern
	 * @param email
	 * @param benutzername
	 * @param passwort
	 * @param new_passwort
	 * @return
	 */
	public String benutzerVerwalten(String email, String benutzername, String passwort, String new_passwort);
	
	/**
	 * AdminMethode zur Blockierung eines Benutzers
	 * @param benutzername
	 * @param email
	 */
	public void benutzerBlockieren(String benutzername, String email);
	
	/**
	 * AdminMethode zur Löschung eines Kommentar
	 * @param KID
	 */
	public void kommentareLoeschen(Long KID);

	/**
	 * Methode zur Prüfung, ob eine Email in der Datenbank bereits vorhanden ist
	 * @return
	 */
	public boolean getEmailInDBVorhanden();
	
	/**
	 * Methode zur Prüfung, ob ein Benutzername in der Datenbank vorhanden ist
	 * @return
	 */
	public boolean getNutzernameInDBVorhanden();
	
	/**
	 * AdminMethode zur Löschung eines Benutzers
	 * @param benutzer
	 * @return
	 */
	public boolean benutzerLoeschen(Benutzer benutzer);

}
