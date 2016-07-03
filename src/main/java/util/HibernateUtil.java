package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author MacBook Klasse zur Hibernate Schnittstelle
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Methode um Session zu erstellen
	 * 
	 * @return
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Methode um Session zu erhalten
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Methode um Session zu beenden
	 */
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
