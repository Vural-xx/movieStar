package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.Benutzer;
import model.Film;
import model.Kommentar;
import util.HibernateUtil;

public class testKommentar {

	public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			Film film = new Film();
			film.setName("testFilm");
			film.setBeschreibung("testBeschreibung");
			
			Benutzer benutzer = new Benutzer();
			benutzer.setBenutzername("test");
			benutzer.setEmail("test@test.de");
			benutzer.setPasswort("Test#124!");
			session.save(benutzer);
	
			benutzer.getErstellteFilme().add(film);
			film.setErsteller(benutzer);
			
			session.save(film);
			
			/*
			
			Kommentar kommentar = new Kommentar();
			kommentar.setId(1);
			kommentar.setText("Hallo");
			Benutzer ersteller = new Benutzer();
			ersteller.setEmail("vural@test.de");
			ersteller.setBenutzername("vural");
			kommentar.setErsteller(ersteller);

			session.save(ersteller);
			session.save(kommentar);*/

			session.getTransaction().commit();
			System.out.println("Done");
		// TODO Auto-generated method stub

	}

}
