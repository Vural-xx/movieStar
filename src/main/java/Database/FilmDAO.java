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
import model.Kommentar;
import util.HibernateUtil;

/**
 * @author MacBook
 * Datenbank für Filme
 */
public class FilmDAO implements interfaces.FilmDAOInterface {

	Configuration con = new Configuration();
	public static String SQLnotification = "";
	public static String sqlStatus = "";
	private final Session session;

	/**
	 * Kontruktor
	 */
	public FilmDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * Getter vom SQL Status
	 * @return
	 */
	public String getSqlStatus() {
		return sqlStatus;
	}

	/**
	 * Setter vom SQL Status
	 * @param sqlStatus
	 */
	public void setSqlStatus(String sqlStatus) {

		this.sqlStatus = sqlStatus;

	}

//	public String getSQLnotification() {
//		return SQLnotification;
//	}
//
//	public void setSQLnotification(String sQLnotification) {
//		SQLnotification = sQLnotification;
//	}

	@Override
	public Film filmErstellen(Film film) {
		session.beginTransaction();
		try {
			session.save(film);
			session.getTransaction().commit();
			setSqlStatus("Film erfolgreich angelegt");
			System.out.println(sqlStatus);
			return film;

		} catch (Exception e) {
			System.err.println("FailFilm");
			sqlStatus = "Film anlegen fehlgeschlagen";
			return null;
		}
	}

	/**
	 * Methode um Änderung im Film aktualisieren
	 * @param film
	 * @return
	 */
	public Film filmUpdate(Film film) {
		// System.out.println(film.getName());
		session.beginTransaction();
		try {
			session.update(film);
			session.getTransaction().commit();
			setSqlStatus("Film update erfolgreich");
			System.out.println(sqlStatus);
			return film;

		} catch (Exception e) {
			System.err.println("FailFilmUpdate");
			return null;
		}
	}

	@Override
	public List<Film> filmFuerErsteller(Benutzer benutzer) {
		session.beginTransaction();

		try {
			Query q = session.createQuery("select filme from Film filme left join fetch filme.ersteller benutzer where benutzer.email = :keyWord");
			q.setParameter("keyWord", benutzer.getEmail());
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

		List<Film> filmList = new ArrayList<Film>();

		try {
			session.beginTransaction();
			// System.out.println(film);
			Query q = session.createQuery("select p from Film p where "
					+ "p.name like :keyWord or p.erscheinungsjahr like " + ":keyWord or p.beschreibung like :keyWord");
			q.setParameter("keyWord", "%" + film + "%");
			filmList = q.list();
			setSqlStatus("Film suche erfolgreich");
			System.out.println(sqlStatus);
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
	public Film filmSuchenByKey(String name, int erscheinungsjahr) {
		List results = null;
		session.clear();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Film.class);
			criteria.add(Restrictions.eq("name", name));
			criteria.add(Restrictions.eq("erscheinungsjahr", erscheinungsjahr));
			results = criteria.list();
			setSqlStatus("Film erfolgreich gesucht");
			session.getTransaction().commit();
			return (Film) results.get(0);
			
		} catch (Exception e) {
			System.err.println("Fail film suchen by");
		}
		return null;
	}
	
	

	@Override
	public List<Film> neusteFilme() {
		List<Film> results = null;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Film.class);
			criteria.addOrder(Order.desc("uploaddatum"));
			results = criteria.list();
			session.getTransaction().commit();
			setSqlStatus("Neue Film List gefunden");
			System.out.println(sqlStatus);
		} catch (Exception e) {
			System.err.println("Fail neuste film");
		}

		return results;
	}

	@Override
	public List<Film> top10() {
		List<Film> results = null;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Film.class);
			criteria.addOrder(Order.desc("sterne"));
			criteria.setMaxResults(5);
			results = criteria.list();
			setSqlStatus("Top10 gefunden");
			System.out.println(sqlStatus);
		} catch (Exception e) {
			System.err.println("Fail top 10");
		}

		return results;
	}

	@Override
	public List<Film> alleFilme() {
		Criteria criteria = null;
		session.clear();
		try {
			session.beginTransaction();
			criteria = session.createCriteria(Film.class);
			session.getTransaction().commit();
			setSqlStatus("Alle Filme gefunden");
			System.out.println(sqlStatus);
		} catch (Exception e) {
			System.err.println("Fail alle FIlme");
		}

		return criteria.list();
	}

	@Override
	public boolean bewerteFilm(Bewertung bewertung, Film film) {
		session.beginTransaction();
		try {
			session.save(bewertung);
			session.update(film);
			session.getTransaction().commit();
			setSqlStatus("Update Film und erstelle Bewertung");
			System.out.println(sqlStatus);
			return true;

		} catch (Exception e) {
			System.err.println("Fail bewerte film");
		}
		return false;
	}

	public boolean filmLoeschen(Film film) {
		session.beginTransaction();

		try {
			session.delete(film);
			session.getTransaction().commit();
			setSqlStatus("Film erfolgreich gelöscht");
			System.out.println(sqlStatus);
			return true;

		} catch (Exception e) {
			System.err.println("Fail");
			sqlStatus = "Film löschen fehlgeschlagen";
			return false;
		}
	}
	
	public boolean filmKommentieren(Kommentar kommentar, Film film) {
		session.beginTransaction();

		try {
			session.save(kommentar);
			session.update(film);
			session.getTransaction().commit();
			setSqlStatus("Film erfolgreich kommentiert");
			System.out.println(sqlStatus);
			return true;

		} catch (Exception e) {
			System.err.println("Fail");
			sqlStatus = "Film kommentieren fehlgeschlagen";
			return false;
		}
	}

}
