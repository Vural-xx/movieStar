package interfaces;

import enums.Status;
import model.Benutzer;

public interface BenutzerDAO {
	
	public boolean benutzerErstellen(Benutzer benutzer); 
	
	public Benutzer benutzerSuchen(Benutzer benutzer);
	
	public String benutzerVorhanden(Benutzer benutzer, String emailOderBenutzername);
	
	public void benutzerBlockieren(Status benutzerstatus, String benutzername, String email);
	
	public boolean kommentareLoeschen(Long KID);

}
