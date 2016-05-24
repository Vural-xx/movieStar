package test;

import org.hibernate.Session;

import model.Benutzer;
import model.Kommentar;
import util.HibernateUtil;

public class testKommentar {

	public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			
			Kommentar kommentar = new Kommentar();
			kommentar.setId(1);
			kommentar.setText("Hallo");
			Benutzer ersteller = new Benutzer();
			ersteller.setEmail("vural@test.de");
			ersteller.setBenutzername("vural");
			kommentar.setErsteller(ersteller);;

			session.save(ersteller);
			session.save(kommentar);

			session.getTransaction().commit();
			System.out.println("Done");
		// TODO Auto-generated method stub

	}

}
