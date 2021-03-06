package controller;

import interfaces.Facade;
import model.Film;
import model.Filter;

public class HauptController implements Facade {
	BenutzerController benutzerController;
	FilmController filmController;
	
	public HauptController() {
		benutzerController = new BenutzerController();
		filmController = new FilmController();
	}

	@Override
	public void registrieren(String email, String benutzername, String passwort) {
		benutzerController.registrieren(email,benutzername,passwort);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logIn(String logIn, String passwort) {
		benutzerController.logIn(logIn, passwort);
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
	public void benutzerVerwalten(String email, String benutzername, String passwort) {
		benutzerController.benutzerVerwalten(email, benutzername, passwort);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmErstellen(Film film) {
		filmController.filmErstellen(film);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmSuchen(String suche) {
		filmController.filmSuchen(suche);
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

}
