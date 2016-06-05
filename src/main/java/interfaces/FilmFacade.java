package interfaces;

import model.Film;
import model.Filter;

public interface FilmFacade {
	
	public String filmErstellen(Film film);
	
	public void filmSuchen(String suche);
	
	public void filmSuchenErweitert(Film film);
	
	public void filmBewerten( Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public void filmFiltern(Filter filter);

}
