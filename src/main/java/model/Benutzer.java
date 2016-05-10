package model;

import java.util.List;


import abstracts.AbstractEntity;
import enums.Rolle;
public class Benutzer extends AbstractEntity {

	private String email;
	private String benutzername;
	private String passwort;
	private Rolle rolle;
	List<Film> erstellteFilme;


	public Benutzer() {
		// TODO Auto-generated constructor stub
	}
	

	public Benutzer(String email, String passwort){
		this.email= email;
		this.passwort= passwort;
	}

	public Benutzer(String email, String benutzername, String passwort){
		this.benutzername= benutzername;
		this.email= email;
		this.passwort= passwort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Rolle getRolle() {
		return rolle;
	}

	public void setRolle(Rolle rolle) {
		this.rolle = rolle;
	}

	public List<Film> getErstellteFilme() {
		return erstellteFilme;
	}

	public void setErstellteFilme(List<Film> erstellteFilme) {
		this.erstellteFilme = erstellteFilme;
	}
	
	

	
}
