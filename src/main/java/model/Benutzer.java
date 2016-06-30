package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enums.BenutzerStatus;
import enums.Rechte;

@Entity
@Table(name = "Benutzer")
@ManagedBean(name = "benutzer")
@SessionScoped
public class Benutzer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7700810203468542310L;
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "benutzername")
	private String benutzername;
	
	@Column(name = "passwort")
	private String passwort;
	
	@Column(name = "rolle")
	@Enumerated(EnumType.STRING)
	private Rechte rechte;
	
	@Column(name = "benutzerstatus")
	@Enumerated(EnumType.STRING)
	private BenutzerStatus benutzerstatus;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ersteller")
	private Collection<Film> erstellteFilme = new ArrayList<Film>(0);


	public Benutzer() {
		// TODO Auto-generated constructor stub
	}
	
	public Benutzer(String benutzername){
		this.benutzername = benutzername;
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


	public Rechte getRechte() {
		return rechte;
	}

	public void setRechte(Rechte rechte) {
		this.rechte = rechte;
	} 
	
	public BenutzerStatus getBenutzerstatus() {
		return benutzerstatus;
	}

	public void setBenutzerstatus(BenutzerStatus benutzerstatus) {
		this.benutzerstatus = benutzerstatus;
	}
	
	public Collection<Film> getErstellteFilme() {
		return erstellteFilme;
	}

	public void setErstellteFilme(Collection<Film> erstellteFilme) {
		this.erstellteFilme = erstellteFilme;
	}
	
	

	
}
