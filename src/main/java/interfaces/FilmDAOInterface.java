package interfaces;

import java.util.List;

import model.Film;
import model.Filter;

public interface FilmDAOInterface {
	
	
	public Film filmErstellen(Film film); 
	
	public List<Film> filmSuchen(String film);
	
	public void filmBewerten(Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public List<Film> filmFiltern(Filter filter);
	
	public List<Film> neusteFilme();
	
	public List<Film> top10();
	
	public Film filmSuchenByName(String name);

}
