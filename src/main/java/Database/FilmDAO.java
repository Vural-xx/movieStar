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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import comparator.FilmComparatorNameAZ;
import model.Benutzer;
import model.Bewertung;
import model.Film;
import model.Filter;
import util.HibernateUtil;

public class FilmDAO implements interfaces.FilmDAOInterface {
	
	public static String SQLnotification = "";
	static String sqlStatus = "";
	
	private final Session session = HibernateUtil.getSessionFactory().openSession();
	
	
	public String getSqlStatus() {
		return sqlStatus;
	}

	public void setSqlStatus(String sqlStatus) {
		BenutzerDAO.sqlStatus = sqlStatus;
	}

	public String getSQLnotification() {
		return SQLnotification;
	}

	public void setSQLnotification(String sQLnotification) {
		SQLnotification = sQLnotification;
	}

	@Override
	public Film filmErstellen(Film film) {
		//System.out.println(film.getName());
		session.beginTransaction();
		try {
			session.save(film);
			session.getTransaction().commit();
			setSqlStatus("Film erfolgreich angelegt");
			System.out.println(sqlStatus);
			return film;

		} catch (Exception e) {
			System.err.println("Fail");
			return null;
		}
	}
	
	public Film filmUpdate(Film film) {
		System.out.println(film.getName());
		session.beginTransaction();
		try {
			session.update(film);
			session.getTransaction().commit();
			setSqlStatus("Film erfolgreich angelegt");
			return film;

		} catch (Exception e) {
			System.err.println("Fail");
			return null;
		}
	}
	
	public List<Film> filmFuerErsteller(Benutzer benutzer){
		session.beginTransaction();

		try {
			Query q= session.createQuery("select filme from Film filme left join fetch filme.ersteller benutzer");
			List results = q.list();
			if (results.size() == 0) {
				return null;
			} else {
				return results;
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
	
		}
		return null;
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
	

	@Override
	public Film filmSuchenByName(String name) {
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.add(Restrictions.eq("name", name));
		List results = criteria.list();
		return (Film) results.get(0);
	}

	@Override
	public List<Film> neusteFilme() {
		
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.addOrder(Order.desc("uploaddatum"));
		List<Film> results = criteria.list();
		session.getTransaction().commit();
	

		return results;
	}


	@Override
	public List<Film> top10() {
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.addOrder(Order.desc("sterne"));
		criteria.setMaxResults(5);
		List<Film> results = criteria.list();
	

		return results;
	}

	@Override
	public List<Film> alleFilme() {
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Film.class);
		session.getTransaction().commit();
		return criteria.list();
	}

	@Override
	public boolean bewerteFilm(Bewertung bewertung, Film film) {
		session.beginTransaction();
		try {
			session.save(bewertung);
			session.update(film);
			session.getTransaction().commit();
			System.out.println("Update Film und erstelle Bewertung");
			return true;

		} catch (Exception e) {
			System.err.println("Fail");
		}
		return false;
	}

	
}
