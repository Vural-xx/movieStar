package interfaces;

import javax.faces.event.AjaxBehaviorEvent;

public interface BenutzerFacade {
	
	public String registrieren(String email, String benutzername, String passwort);

	public String logIn(String logIn, String passwort);
	
	public void logOut();
	
	public void passwortVergessen(String email, String benutzername, String passwort);
	
	public void benutzerVerwalten(String email, String benutzername, String passwort, String new_passwort);
	
	public void benutzerBlockieren(String benutzername, String email);
	
	public void kommentareLoeschen(Long KID);

	public boolean getEmailInDBVorhanden();
	
	public boolean getNutzernameInDBVorhanden();

}
