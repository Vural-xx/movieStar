package interfaces;

import enums.Status;
import model.Benutzer;

public interface BenutzerDAOInterface {
	
	public boolean benutzerErstellen(Benutzer benutzer); 
	
	public Benutzer benutzerSuchen(Benutzer benutzer);
	
	public boolean benutzerVorhanden(Benutzer benutzer, String emailOderBenutzername);
	
	public Benutzer benutzerUpdate(Benutzer benutzer);
	
	public void benutzerBlockieren(Status benutzerstatus, String benutzername, String email);
	
	public boolean kommentareLoeschen(Long KID);

	public boolean benutzerLoeschen(Benutzer benutzer);
}
