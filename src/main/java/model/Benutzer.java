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

/**
 * @author MacBook Klasse Benutzer
 */
@Entity
@Table(name = "Benutzer")
@ManagedBean(name = "benutzer")
@SessionScoped
public class Benutzer implements Serializable {

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

	/**
	 * Konstruktor von Benutzer
	 */
	public Benutzer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Konstruktor von Benutzer
	 * 
	 * @param benutzername
	 */
	public Benutzer(String benutzername) {
		this.benutzername = benutzername;
	}

	/**
	 * Konstruktor von Benutzer
	 * 
	 * @param email
	 * @param passwort
	 */
	public Benutzer(String email, String passwort) {
		this.email = email;
		this.passwort = passwort;
	}

	/**
	 * Konstruktor von Benutzer
	 * 
	 * @param email
	 * @param benutzername
	 * @param passwort
	 */
	public Benutzer(String email, String benutzername, String passwort) {
		this.benutzername = benutzername;
		this.email = email;
		this.passwort = passwort;
		this.benutzerstatus = BenutzerStatus.FREIGESCHALTET;
		this.rechte = Rechte.BENUTZER;
	}

	/**
	 * Getter von Email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter von Email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter von Benutzername
	 * 
	 * @return
	 */
	public String getBenutzername() {
		return benutzername;
	}

	/**
	 * Setter von Benutzername
	 * 
	 * @param benutzername
	 */
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	/**
	 * Getter von Passwort
	 * 
	 * @return
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * Setter von Passwort
	 * 
	 * @param passwort
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * Getter von Rechte
	 * 
	 * @return
	 */
	public Rechte getRechte() {
		return rechte;
	}

	/**
	 * Setter von Rechte
	 * 
	 * @param rechte
	 */
	public void setRechte(Rechte rechte) {
		this.rechte = rechte;
	}

	/**
	 * Getter von Benutzerstatus
	 * 
	 * @return
	 */
	public BenutzerStatus getBenutzerstatus() {
		return benutzerstatus;
	}

	/**
	 * Setter von Benutzerstatus
	 * 
	 * @param benutzerstatus
	 */
	public void setBenutzerstatus(BenutzerStatus benutzerstatus) {
		this.benutzerstatus = benutzerstatus;
	}

	/**
	 * Getter von erstellte Filme
	 * 
	 * @return
	 */
	public Collection<Film> getErstellteFilme() {
		return erstellteFilme;
	}

	/**
	 * Setter von erstellte Filme
	 * 
	 * @param erstellteFilme
	 */
	public void setErstellteFilme(Collection<Film> erstellteFilme) {
		this.erstellteFilme = erstellteFilme;
	}

}
