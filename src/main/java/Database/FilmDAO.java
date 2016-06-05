package Database;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Benutzer;
import model.Film;
import model.Filter;
import util.HibernateUtil;

public class FilmDAO implements interfaces.FilmDAO {
	
	private final Session session = HibernateUtil.getSessionFactory().openSession();
	

	@Override
	public Film filmErstellen(Film film) {
		System.out.println(film.getName());
		session.beginTransaction();
		try {
			session.save(film);
			session.getTransaction().commit();
			System.out.println("Film erfolgreich angelegt");
			return film;

		} catch (Exception e) {
			System.err.println("Fail");
			return null;
		}
	}

	@Override
	public List<Film> filmSuchen(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void filmBewerten(Long FID, double sterne) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filmKommentieren(Long FID, String kommentar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Film> filmFiltern(Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Film> findAlle(){
		Criteria criteria = session.createCriteria(Film.class);
		return criteria.list();
	}
}
