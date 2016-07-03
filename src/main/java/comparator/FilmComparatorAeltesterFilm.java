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
		if(o1.getErscheinungsjahr() > o2.getErscheinungsjahr()){
			return 1;
		}else if(o1.getErscheinungsjahr() == o2.getErscheinungsjahr()){
			return 0;
		}else{
			return -1;
		}
		
	}

}
