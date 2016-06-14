package Database;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import enums.Status;
import interfaces.BenutzerDAOInterface;
import model.Benutzer;
import model.Film;
import model.Filter;
import util.HibernateUtil;

@ManagedBean(name = "benutzerDAO")
public class BenutzerDAO implements BenutzerDAOInterface {

	Configuration con = new Configuration();
	public static String SQLnotification = "";
	private static String sqlStatus = "";
	
	private final Session session;
	
	public BenutzerDAO() {
		session =  HibernateUtil.getSessionFactory().openSession();
	}
	
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
	public boolean benutzerErstellen(Benutzer benutzer) {

		session.beginTransaction();

		try {
			session.save(benutzer);
			System.out.println("Object Saved");
			session.getTransaction().commit();
			setSqlStatus("Erfolgreich registriert");
			System.out.println(sqlStatus);
			return true;

		} catch (Exception e) {
			System.err.println("Fail");
			sqlStatus = "Registrierung fehlgeschlagen";
			return false;
		}

		// TODO Auto-generated method stub

	}

	@Override
	public Benutzer benutzerSuchen(Benutzer benutzer) {

		session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(Benutzer.class);
			criteria.add(Restrictions.or(
					Restrictions.eq("email", benutzer.getEmail()), 
					Restrictions.eq("benutzername", benutzer.getEmail())));
			if(!benutzer.getPasswort().equals("")){
				criteria.add(Restrictions.eq("passwort", benutzer.getPasswort()));
			}
			List results = criteria.list();
			if (results.size() == 0) {
				return null;
			} else {
				Benutzer dbBenutzer = (Benutzer) results.get(0);
				return dbBenutzer;
			}
			
		} catch (Exception e) {
			System.err.println("Fail");
			sqlStatus = "Suche fehlgeschlagen";
		}

		// TODO Auto-generated method stub
		return null;
	}

	public boolean benutzerVorhanden(Benutzer benutzer, String emailOderBenutzername) {
		Query query;
		List results = null;
		String vorhanden = "";

		session.beginTransaction();

		try {
			if(emailOderBenutzername.equals("E-mail")){
				String selectionQuery = "from Benutzer where email = :email";
				query = session.createQuery(selectionQuery);
				query.setParameter("email", benutzer.getEmail());
			}else{
				String selectionQuery = "from Benutzer where benutzername = :benutzername";
				query = session.createQuery(selectionQuery);
				query.setParameter("benutzername", benutzer.getBenutzername());
			}
			
			results = query.list();
			
			if (results.size() == 0) {
				return false;
			} else {
				return true;
			}
			
		} catch (Exception e) {
			System.err.println("Fail");
			sqlStatus = "Suche fehlgeschlagen";
		}

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Benutzer benutzerUpdate(Benutzer benutzer) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		
		session.update(benutzer);
		session.getTransaction().commit();
		
		
		return null;
	}





	@Override
	public void benutzerBlockieren(Status benutzerstatus, String benutzername, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean kommentareLoeschen(Long KID) {
		// TODO Auto-generated method stub
		return false;
	}

	public void statusAenderung(AjaxBehaviorEvent event) {
		setSQLnotification(getSqlStatus());
	}



}
