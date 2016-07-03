package interfaces;

import java.util.List;

import model.Bewertung;
import model.Film;
import model.Filter;

/**
 * @author MacBook Interface zur FilmFacade
 *
 */
public interface FilmFacade {

	/**
	 * Methode zur Erstellung eines Films
	 * 
	 * @param film
	 * @return
	 */
	public String filmErstellen(Film film);

	/**
	 * Methode zum Suchen eines Films
	 * 
	 * @param suche
	 * @return
	 */
	public String filmSuchen(String suche);

	/**
	 * Methode zur Auswahl der neuesten Filme
	 * 
	 * @return
	 */
	public String neusteFilme();

	/**
	 * Methode zur Auswahl von allen Filmen
	 * 
	 * @return
	 */
	public String alleFilme();

	/**
	 * Methode zur Auswahl der 10 besten Filme
	 * 
	 * @return
	 */
	public List<Film> top10();

	/**
	 * Methode zur Auswahl der best bewertesten Filme
	 * 
	 * @return
	 */
	public String bewerteFilm();

	/**
	 * Methode zur Auswahl der Filme von einem Benutzer
	 * 
	 * @return
	 */
	public String filmFuerErsteller();

	/**
	 * Methode zur Sortierung der Filme
	 * 
	 * @param sortiertyp
	 * @return
	 */
	public String sortiereFilm(String sortiertyp);

	/**
	 * Methode zur Bewertung von Filmen
	 * 
	 * @param FID
	 * @param sterne
	 * @return
	 */
	public boolean filmBewerten(Long FID, double sterne);

	/**
	 * Methode zur Kommentierung von Filmen
	 * 
	 * @param FID
	 * @param kommentar
	 * @return
	 */
	public boolean filmKommentieren(Long FID, String kommentar);

	/**
	 * Adminfunktion zur Löschung von Filmen
	 * 
	 * @param film
	 * @return
	 */
	public boolean filmLoeschen(Film film);

	/**
	 * Prüft ob ein Film von dem selben nutzer bereits bewertet wurde
	 * 
	 * @param benutzer
	 * @param film
	 * @return
	 */

	public boolean filmBereitsBewertet();

}
