package interfaces;

import java.util.List;

import enums.Status;
import model.Benutzer;
import model.Film;
import model.Filter;


public interface DAO {

	public boolean benutzerErstellen(Benutzer benutzer); 
	
	public Benutzer benutzerSuchen(Benutzer benutzer);
	
	public String benutzerVorhanden(Benutzer benutzer, String emailOderBenutzername);
	
	public Film filmErstellen(Film film); 
	
	public List<Film> filmSuchen(Film film);
	
	public void filmBewerten(Long FID, double sterne);
	
	public void filmKommentieren(Long FID, String kommentar);
	
	public List<Film> filmFiltern(Filter filter); 
	
	public void benutzerBlockieren(Status benutzerstatus, String benutzername, String email);
	
	public boolean kommentareLoeschen(Long KID);
}
