package Database;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import model.Benutzer;
import model.Film;
import model.Filter;
import util.HibernateUtil;

public class FilmDAO implements interfaces.FilmDAOInterface {
	
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
	public List<Film> filmSuchen(String film) {
		
		List<Film> filmList= new ArrayList<Film>();
		
		try {
			session.beginTransaction();
			System.out.println(film);
			Query q= session.createQuery("select p from Film p where " + "p.name like :keyWord or p.erscheinungsjahr like " + ":keyWord or p.beschreibung like :keyWord");
			q.setParameter("keyWord", "%"+film+"%");
			filmList = q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			// TODO: handle exception
		}
		return filmList;
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

	@Override
	public Film filmSuchenByName(String name) {
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.add(Restrictions.eq("name", name));
		List results = criteria.list();
		return (Film) results.get(0);
	}
}
