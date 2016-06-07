package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;

import Database.FilmDAO;
import enums.Genre;
import interfaces.FilmFacade;
import model.Feld;
import model.Film;
import model.Filter;

@ManagedBean(name="filmController")
@SessionScoped
public class FilmController implements FilmFacade {
	
	private Film film;
	private FilmDAO filmDAO;

	@ManagedProperty(value="#{navigationController}")
	private NavigationController navigationController;
	private List filme;
	private List<Feld> felder = new ArrayList<Feld>();
	

	public FilmController() {
		filmDAO = new FilmDAO();
	}
	
	public Film getFilm() {
		return film;
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
	public String filmSuchen(String suche) {
		filme = filmDAO.filmSuchen(suche);
		return navigationController.toSuche();
		
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
	
	public void filmVorbereiten(ComponentSystemEvent event){
		this.film = new Film();
		System.out.println("Bin drin");
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
	
	public String selectFilm(String  name){
		film = filmDAO.filmSuchenByName(name);
		return navigationController.toFilm();
	}

	public List<Feld> getFelder() {
		return felder;
	}

	public void setFelder(List<Feld> felder) {
		this.felder = felder;
	}

}
