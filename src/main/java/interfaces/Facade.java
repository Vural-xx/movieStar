package interfaces;

import model.Film;
import model.Filter;

public interface Facade {

	public String registrieren(String email, String benutzername, String passwort);

	public void logIn(String logIn, String passwort);
	
	public void logOut();
	
	public void passwortVergessen(String email, String benutzername, String passwort);
	
	public void benutzerVerwalten(String email, String benutzername, String passwort);
	
	public void filmErstellen(Film film);
	
	public void filmSuchen(String suche);
	
	public void filmSuchenErweitert(Film film);
	
	public void filmBewerten( Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public void filmFiltern(Filter filter);
	
	public void benutzerBlockieren(String benutzername, String email);
	
	public void kommentareLoeschen(Long KID);
}
