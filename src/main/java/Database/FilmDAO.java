package Database;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Film;
import model.Filter;
import util.HibernateUtil;

public class FilmDAO implements interfaces.FilmDAO {
	
	Configuration con = new Configuration();
	public static String sqlNotification = "";
	private static String sqlStatus = "";
	
	public FilmDAO(){
		con.configure("local.sql.cfg.xml");
		con.addResource("film.hbm.xml");
	}

	public String getSqlStatus() {
		return sqlStatus;
	}

	public void setSqlStatus(String sqlStatus) {
		FilmDAO.sqlStatus = sqlStatus;
	}

	public String getSqlNotification() {
		return sqlNotification;
	}

	public void setSqlNotification(String sqlNotification) {
		FilmDAO.sqlNotification = sqlNotification;
	}

	@Override
	public Film filmErstellen(Film film) {
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println(film.getName());

		Transaction transaction = session.beginTransaction();

		try {
			session.save(film);
			System.out.println("Object Saved");
			transaction.commit();
			session.close();
			sessionFactory.close();
			setSqlStatus("Film erfolgreich angelegt");
			System.out.println(sqlStatus);
			return film;

		} catch (Exception e) {
			System.err.println("Fail");
			sqlStatus = "Film anlegen fehlgeschlagen";
			return null;
		}
	}

	@Override
	public List<Film> filmSuchen(String film) {
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session s= null;
		try {
			s= HibernateUtil.getSessionFactory().getCurrentSession();
		} catch (org.hibernate.HibernateException he) {
			s= sessionFactory.openSession();
		}
		
		
		List<Film> filmList= new ArrayList<Film>();
		
		try {
			s.beginTransaction();
			System.out.println(film);
			Query q= s.createQuery("select p from Film p where " + "p.name like :keyWord or p.erscheinungsjahr like " + ":keyWord or p.beschreibung like :keyWord");
			q.setParameter("keyWord", "%"+film+"%");
			filmList = q.list();
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
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

}
