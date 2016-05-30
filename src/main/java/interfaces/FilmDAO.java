package interfaces;

import java.util.List;

import model.Film;
import model.Filter;

public interface FilmDAO {
	
	
	public Film filmErstellen(Film film); 
	
	public List<Film> filmSuchen(String film);
	
	public void filmBewerten(Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public List<Film> filmFiltern(Filter filter);

}
