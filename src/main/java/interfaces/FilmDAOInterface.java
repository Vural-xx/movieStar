package interfaces;

import java.util.List;

import model.Benutzer;
import model.Bewertung;
import model.Film;
import model.Filter;

public interface FilmDAOInterface {
	
	
	public Film filmErstellen(Film film); 
	
	public List<Film> filmSuchen(String film);
	
	public void filmBewerten(Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public List<Film> filmFiltern(Filter filter);
	
	public List<Film> neusteFilme();
	
	public List<Film> alleFilme();
	
	public List<Film> top10();
	
	public List<Film> filmFuerErsteller(Benutzer benutzer);
	
	public boolean bewerteFilm(Bewertung bewertung, Film film);
	
	public Film filmSuchenByName(String name);
	
	public boolean filmVorhanden(Film film);

}
