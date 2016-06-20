package controller;

import java.util.List;

import interfaces.BenutzerFacade;
import interfaces.FilmFacade;
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
	public void logOut() {
		benutzerController.logOut();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passwortVergessen(String email, String benutzername, String passwort) {
		benutzerController.passwortVergessen(email, benutzername, passwort);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void benutzerVerwalten(String email, String benutzername, String passwort, String neues_passwort) {
		benutzerController.benutzerVerwalten(email, benutzername, passwort, neues_passwort);
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
	public void filmSuchenErweitert(Film film) {
		filmController.filmSuchenErweitert(film);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmBewerten(Long FID, double sterne) {
		filmController.filmBewerten(FID, sterne);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmKommentieren(Long FID, String kommentar) {
		filmController.filmKommentieren(FID, kommentar);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmFiltern(Filter filter) {
		filmController.filmFiltern(filter);
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
	public List<Film> neusteFilme() {
		return filmController.neusteFilme();
	}

	@Override
	public List<Film> top10() {
		return filmController.top10();
	}
	
	

}
