package Database;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import enums.Status;
import interfaces.BenutzerDAO;
import model.Benutzer;
import model.Film;
import model.Filter;
import util.HibernateUtil;

@ManagedBean(name = "SQLDatabase")
public class SQLDatabase implements BenutzerDAO {

	Configuration con = new Configuration();
	public static String SQLnotification = "";
	private static String sqlStatus = "";
	
	private final Session session = HibernateUtil.getSessionFactory().openSession();
	
	public SQLDatabase(){
		con.configure("local.sql.cfg.xml");
		con.addResource("user.hbm.xml");
		con.addResource("film.hbm.xml");
	}

	public String getSqlStatus() {
		return sqlStatus;
	}

	public void setSqlStatus(String sqlStatus) {
		SQLDatabase.sqlStatus = sqlStatus;
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
			String selectionQuery = "from Benutzer where (email = :email OR benutzername = :benutzername)";
			boolean passwortGesetzt = false;
			if (!benutzer.getPasswort().equals("")) {
				selectionQuery = selectionQuery + " AND passwort = :passwort ";
				passwortGesetzt = true;
			}
			Query query = session.createQuery(selectionQuery);
			query.setParameter("email", benutzer.getEmail());
			query.setParameter("benutzername", benutzer.getEmail());
			if (passwortGesetzt) {
				query.setParameter("passwort", benutzer.getPasswort());
			}
			List results = query.list();
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
