package interfaces;

import java.util.List;

import model.Film;
import model.Filter;

public interface FilmDAOInterface {
	
	
	public Film filmErstellen(Film film); 
	
	public List<Film> filmSuchen(Film film);
	
	public void filmBewerten(Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public List<Film> filmFiltern(Filter filter);
	
	public Film filmSuchenByName(String name);

}
