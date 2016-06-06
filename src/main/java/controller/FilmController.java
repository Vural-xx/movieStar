package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import Database.FilmDAO;
import enums.Genre;
import interfaces.FilmFacade;
import model.Film;
import model.Filter;

@ManagedBean(name="filmController")
@RequestScoped
public class FilmController implements FilmFacade {
	
	@ManagedProperty(value="#{film}")
	private Film film;
	private FilmDAO filmDAO;
	@ManagedProperty(value="#{navigationController}")
	private NavigationController navigationController;
	private List filme;
	

	public FilmController() {
		filmDAO = new FilmDAO();
	}
	
	public void setFilm(Film film){
		this.film = film;
	}

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}
	
	@Override
	public String filmErstellen(Film film) {
		filmDAO.filmErstellen(film);
		return listeVorbereiten();
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
	
	public String listeVorbereiten(){
		this.setFilme(filmDAO.findAlle());
		return navigationController.toFilmListe();
	}

	public List getFilme() {
		return filme;
	}

	public void setFilme(List filme) {
		this.filme = filme;
	}
	
	public SelectItem[] getGenreValues() {
	    SelectItem[] items = new SelectItem[Genre.values().length];
	    int i = 0;
	    for(Genre g: Genre.values()) {
	      items[i++] = new SelectItem(g, g.getLabel());
	    }
	    return items;
	  }

}
