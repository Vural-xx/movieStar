package interfaces;

import java.util.List;

import model.Bewertung;
import model.Film;
import model.Filter;

public interface FilmFacade {
	
	public String filmErstellen(Film film);
	
	public String filmSuchen(String suche);
	
	public boolean filmSuchenErweitert(Film film);
	
	public String neusteFilme();
	
	public String alleFilme();
	
	public List<Film> top10();
	
	public String bewerteFilm();

	public String sortiereFilm(String sortiertyp);
	
	public boolean filmBewerten( Long FID, double sterne);
	
	public boolean filmKommentieren(Long FID, String kommentar);
	
	public boolean filmFiltern(Filter filter);
	
	public boolean filmLoeschen(Film film);

}
