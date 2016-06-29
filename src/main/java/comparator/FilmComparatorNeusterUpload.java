package comparator;

import java.util.Comparator;

import model.Film;

public class FilmComparatorNeusterUpload implements Comparator<Film> {
	
	@Override
	public int compare(Film o1, Film o2) {
		return o1.getUploaddatum().toString().compareTo(o2.getUploaddatum().toString());
	}

}