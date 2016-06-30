package comparator;

import java.util.Comparator;

import model.Film;

/**
 * @author MacBook
 * Zur Sortierung nach dem ältesten Upload
 *
 */
public class FilmComparatorAeltesterUpload implements Comparator<Film> {

	@Override
	public int compare(Film o1, Film o2) {
		return o2.getUploaddatum().toString().compareTo(o1.getUploaddatum().toString());
	}
}
