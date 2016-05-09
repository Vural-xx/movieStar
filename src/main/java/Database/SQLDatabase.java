package Database;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import enums.Status;
import interfaces.DAO;
import model.Benutzer;
import model.Film;
import model.Filter;


@ManagedBean(name = "SQLDatabase")
public class SQLDatabase implements DAO {
	
	
	Configuration con = new Configuration();
	public static String SQLnotification ="";
	private static String sqlStatus ="";
	
	
	
	
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
		con.configure("local.sql.cfg.xml");
		con.addResource("user.hbm.xml");
		SessionFactory sessionFactory= con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			session.save(benutzer);
			System.out.println("Object Saved");
			transaction.commit();
			session.close();
			sessionFactory.close();
			setSqlStatus("Erfolgreich registriert");
			System.out.println(sqlStatus);
			return true;
			
		} catch (Exception e) {
			System.err.println("Fail");
			sqlStatus="Registrierung fehlgeschlagen";
			return false;
		}

		// TODO Auto-generated method stub
		
	}

	@Override
	public Benutzer benutzerSuchen(Benutzer benutzer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film filmErstellen(Film film) {
		// TODO Auto-generated method stub
		return null;
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
