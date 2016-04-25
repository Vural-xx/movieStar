package model;

public class Benutzer {

	private String email;
	private String benutzername;
	private String passwort;

	public Benutzer() {
		// TODO Auto-generated constructor stub
	}
	
	public Benutzer(String email, String benutzername, String passwort){
		this.benutzername= benutzername;
		this.email= email;
		this.passwort= passwort;
	}

}
