package comparator;

import java.util.Comparator;

import model.Film;

public class FilmComparatorNameAZ implements Comparator<Film>  {

	@Override
	public int compare(Film o1, Film o2) {
		return o2.getName().toString().compareTo(o1.getName().toString());
	}


}
