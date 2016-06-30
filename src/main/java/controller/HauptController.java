package controller;

import java.util.List;

import interfaces.BenutzerFacade;
import interfaces.FilmFacade;
import model.Benutzer;
import model.Bewertung;
import model.Film;
import model.Filter;

public class HauptController implements BenutzerFacade, FilmFacade {
	BenutzerController benutzerController;
	FilmController filmController;
	
	public HauptController() {
		benutzerController = new BenutzerController();
		filmController = new FilmController();
	}

	@Override
	public String registrieren(String email, String benutzername, String passwort) {
		return benutzerController.registrieren(email,benutzername,passwort);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String logIn(String logIn, String passwort) {
		return benutzerController.logIn(logIn, passwort);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String logOut() {
		return benutzerController.logOut();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passwortVergessen(String email, String benutzername, String passwort) {
		benutzerController.passwortVergessen(email, benutzername, passwort);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean benutzerVerwalten(String email, String benutzername, String passwort, String neues_passwort) {
		return benutzerController.benutzerVerwalten(email, benutzername, passwort, neues_passwort);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String filmErstellen(Film film) {
		return filmController.filmErstellen(film);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String filmSuchen(String suche) {
		return filmController.filmSuchen(suche);
		// TODO Auto-generated method stub
	}
	

	@Override
	public boolean filmSuchenErweitert(Film film) {
		return filmController.filmSuchenErweitert(film);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean filmBewerten(Long FID, double sterne) {
		return filmController.filmBewerten(FID, sterne);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean filmKommentieren(Long FID, String kommentar) {
		return filmController.filmKommentieren(FID, kommentar);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean filmFiltern(Filter filter) {
		return filmController.filmFiltern(filter);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void benutzerBlockieren(String benutzername, String email) {
		benutzerController.benutzerBlockieren(benutzername, email);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kommentareLoeschen(Long KID) {
		benutzerController.kommentareLoeschen(KID);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEmailInDBVorhanden() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getNutzernameInDBVorhanden() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String neusteFilme() {
		return filmController.neusteFilme();
	}

	@Override
	public List<Film> top10() {
		return filmController.top10();
	}

	@Override
	public String alleFilme() {
		return filmController.alleFilme();
	}

	@Override
	public boolean benutzerLoeschen(Benutzer benutzer) {
		return benutzerController.benutzerLoeschen(benutzer);
	}
		
	@Override
	public String sortiereFilm(String sortiertyp) {
		return filmController.sortiereFilm(sortiertyp);
	}

	@Override
	public String bewerteFilm() {
		return filmController.bewerteFilm();
	}

	@Override
	public boolean filmLoeschen(Film film) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
