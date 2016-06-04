package Database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Kommentar;
import util.HibernateUtil;

public class KommentarDAO {

	private final Session session = HibernateUtil.getSessionFactory().openSession();
	
	public KommentarDAO(){
		
	}
	
	public void findKommentarByText(String text){
		Criteria criteria = session.createCriteria(Kommentar.class)
				   .add(Restrictions.eq("text", text));
	}
}
