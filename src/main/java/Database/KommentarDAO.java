package Database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Kommentar;
import util.HibernateUtil;

/**
 * @author MacBook
 * Datenbank für Kommentare
 *
 */
public class KommentarDAO {

	private final Session session = HibernateUtil.getSessionFactory().openSession();
	
	/**
	 * Konstruktor der KommentarDAO
	 */
	public KommentarDAO(){
		
	}
	
	/**
	 * Methode um Kommentare zu finden
	 * @param text
	 */
	public void findKommentarByText(String text){
		Criteria criteria = session.createCriteria(Kommentar.class)
				   .add(Restrictions.eq("text", text));
	}
}
