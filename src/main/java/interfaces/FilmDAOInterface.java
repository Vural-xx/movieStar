package interfaces;

import java.util.List;

import model.Benutzer;
import model.Bewertung;
import model.Film;
import model.Filter;

/**
 * @author MacBook
 * Interface zur FilmDAO
 *
 */
public interface FilmDAOInterface {
	
	
	/**
	 * Methode zur Erstellung eines Films
	 * @param film
	 * @return
	 */
	public Film filmErstellen(Film film); 
	
	/**
	 * Methode zur Suche eines Films
	 * @param film
	 * @return
	 */
	public List<Film> filmSuchen(String film);
	
	/**
	 * Methode zur Bewertung eines Films
	 * @param FID
	 * @param sterne
	 */
	public void filmBewerten(Long FID, double sterne);
	
	/**
	 * Methode zur Kommentierung eines Films
	 * @param FID
	 * @param kommentar
	 */
	public void filmKommentieren(Long FID, String kommentar);
	
	/**
	 * Methode zur Filterung eines Films
	 * @param filter
	 * @return
	 */
	public List<Film> filmFiltern(Filter filter);
	
	/**
	 * Methode zur Auswahl der neuesten Filme
	 * @return
	 */
	public List<Film> neusteFilme();
	
	/**
	 * Methode zur Auswahl von allen Filmen
	 * @return
	 */
	public List<Film> alleFilme();
	
	/**
	 * Methode zur Auswahl der 10 besten Filme
	 * @return
	 */
	public List<Film> top10();
	
	/**
	 * Methode zur Auswahl der von einem Benutzer erstellten Filme
	 * @param benutzer
	 * @return
	 */
	public List<Film> filmFuerErsteller(Benutzer benutzer);
	
	/**
	 * Methode zur Bewertung von Filmen
	 * @param bewertung
	 * @param film
	 * @return
	 */
	public boolean bewerteFilm(Bewertung bewertung, Film film);
	
	/**
	 * Methode zur Suche des Film nach dem Namen und Erscheinungsjahr
	 * @param name
	 * @param erscheinungsjahr
	 * @return
	 */
	public Film filmSuchenByKey(String name, int erscheinungsjahr);
	

}
