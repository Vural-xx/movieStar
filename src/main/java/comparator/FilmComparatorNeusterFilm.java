package comparator;

import java.util.Comparator;

import model.Film;

/**
 * @author MacBook
 * Zur Sortierung nach den neuesten Filmen
 *
 */
public class FilmComparatorNeusterFilm implements Comparator<Film> {

	@Override
	public int compare(Film o1, Film o2) {
		return o1.getErscheinungsjahr().toString().compareTo(o2.getErscheinungsjahr().toString());
		
	}

}
