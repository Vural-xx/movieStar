package interfaces;

import java.util.List;

import model.Bewertung;
import model.Film;
import model.Filter;

public interface FilmFacade {
	
	public String filmErstellen(Film film);
	
	public String filmSuchen(String suche);
	
	public void filmSuchenErweitert(Film film);
	
	public String neusteFilme();
	
	public String alleFilme();
	
	public List<Film> top10();
	
	public String bewerteFilm();
	
	public String filmFuerErsteller();

	public String sortiereFilm(String sortiertyp);
	
	public void filmBewerten( Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public void filmFiltern(Filter filter);
	
	public boolean filmLoeschen(Film film);

}
