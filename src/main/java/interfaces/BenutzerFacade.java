package interfaces;

public interface BenutzerFacade {
	
	public void registrieren(String email, String benutzername, String passwort);

	public void logIn(String logIn, String passwort);
	
	public void logOut();
	
	public void passwortVergessen(String email, String benutzername, String passwort);
	
	public void benutzerVerwalten(String email, String benutzername, String passwort);
	
	public void benutzerBlockieren(String benutzername, String email);
	
	public void kommentareLoeschen(Long KID);

}
