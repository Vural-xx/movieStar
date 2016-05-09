package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataInsertion {

	public static void main(String[] args) {
		 new DataInsertion().insertInfo();
		

	}
	
	public void insertInfo(){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		DataProvider dataProvider= new DataProvider();
		
		dataProvider.setUser_id(122);
		dataProvider.setUser_name("Vural");
		dataProvider.setAddress("delmen1");
		
		Transaction transaction = session.beginTransaction();
		
		try {
			session.save(dataProvider);
			System.out.println("Object Saved");
			transaction.commit();
			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			System.err.println("Fail");
		}

		
		
		
	}

}
