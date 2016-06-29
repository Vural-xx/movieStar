package comparator;

import java.util.Comparator;

import model.Film;

public class FilmComparatorNiedrigsteSterne implements Comparator<Film> {
	
	@Override
	public int compare(Film o1, Film o2) {
		if(o1.getSterne() < o2.getSterne()){
			return -1;
		}else if(o1.getSterne() == o2.getSterne()){
			return 0;
		}else{
			return 1;
		}
		
	}

}
