package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import enums.Rechte;
import model.Benutzer;
import model.Film;
import model.Kommentar;
import util.HibernateUtil;

public class testKommentar {

	public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			Film film = new Film();
			film.setName("testFilme");
			film.setBeschreibung("testBeschreibung");
			
			Benutzer benutzer = new Benutzer();
			benutzer.setBenutzername("test");
			benutzer.setEmail("test@test.de");
			benutzer.setPasswort("Test#124!");
			benutzer.setRechte(Rechte.BENUTZER);
			session.save(benutzer);
	
			benutzer.getErstellteFilme().add(film);
			film.setErsteller(benutzer);
			
			Kommentar kommentar = new Kommentar();
			kommentar.setErsteller(benutzer);
			kommentar.setText("Hier kommt ein Kommentar");
			List<Kommentar>kommentare = new ArrayList<Kommentar>();
			kommentare.add(kommentar);
			film.setKommentare(kommentare);
			session.save(kommentar);
			session.save(film);
			
		
			session.getTransaction().commit();
			System.out.println("Done");

	}

}
