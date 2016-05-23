package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import Database.FilmDAO;
import interfaces.FilmFacade;
import model.Film;
import model.Filter;

@ManagedBean(name="filmController")
@RequestScoped
public class FilmController implements FilmFacade {
	
	@ManagedProperty(value="#{film}")
	private Film film;
	private FilmDAO filmDAO;
	
	public FilmController() {
		filmDAO = new FilmDAO();
	}
	
	public void setFilm(Film film){
		this.film = film;
	}

	@Override
	public void filmErstellen(Film film) {
		filmDAO.filmErstellen(film);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmSuchen(String suche) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmSuchenErweitert(Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmBewerten(Long FID, double sterne) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmKommentieren(Long FID, String kommentar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmFiltern(Filter filter) {
		// TODO Auto-generated method stub
		
	}

}
