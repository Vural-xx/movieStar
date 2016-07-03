package interfaces;

import enums.BenutzerStatus;
import model.Benutzer;

/**
 * @author MacBook Interface für BenutzerDAO
 *
 */
public interface BenutzerDAOInterface {

	/**
	 * Methode zum Erstellen eines Benutzers in der Datenbank
	 * 
	 * @param benutzer
	 * @return benutzer
	 */
	public boolean benutzerErstellen(Benutzer benutzer);

	/**
	 * Methode zum Suchen eines Benutzers in der Datenbank
	 * 
	 * @param benutzer
	 * @return benutzer
	 */
	public Benutzer benutzerSuchen(Benutzer benutzer);

	/**
	 * Methode zur Überprüfung, ob ein Benutzer (mit Email oder Benutzername)
	 * bereits in der Datenbank vorhanden ist
	 * 
	 * @param benutzer
	 * @param emailOderBenutzername
	 * @return benutzer
	 */
	public boolean benutzerVorhanden(Benutzer benutzer, String emailOderBenutzername);

	/**
	 * Methode zur Akutalisierung der Benutzerdaten
	 * 
	 * @param benutzer
	 * @return
	 */
	public Benutzer benutzerUpdate(Benutzer benutzer);

	/**
	 * AdminMethode zur Löschung eines Benutzers
	 * 
	 * @param benutzer
	 * @return
	 */
	public boolean benutzerLoeschen(Benutzer benutzer);
}
