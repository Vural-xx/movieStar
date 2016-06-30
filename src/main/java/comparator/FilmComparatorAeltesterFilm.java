package comparator;

import java.util.Comparator;

import model.Film;

/**
 * @author MacBook
 * Zur Sortierung nach dem ältesten Film
 *
 */
public class FilmComparatorAeltesterFilm implements Comparator<Film> {

	@Override
	public int compare(Film o1, Film o2) {
		return o2.getErscheinungsjahr().toString().compareTo(o1.getErscheinungsjahr().toString());
	}

}
