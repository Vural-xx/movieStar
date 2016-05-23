package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import interfaces.FilmFacade;
import model.Film;
import model.Filter;

@ManagedBean(name="filmController")
@RequestScoped
public class FilmController implements FilmFacade {
	
	@ManagedProperty(value="#{film}")
	private Film film;

	@Override
	public void filmErstellen(Film film) {
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
