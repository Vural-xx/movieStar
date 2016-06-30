package comparator;

import java.util.Comparator;

import model.Film;

/**
 * @author MacBook
 * Zur Sortierung nach Namen von Z nach A
 *
 */
public class FilmComparatorNameZA implements Comparator<Film> {

	@Override
	public int compare(Film o1, Film o2) {
		return o1.getName().toString().compareTo(o2.getName().toString());
	}

}
