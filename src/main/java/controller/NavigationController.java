package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author MacBook
 *
 */
@ManagedBean
@SessionScoped
public class NavigationController {

	/**
	 * Wechsel zur Register Seite
	 * 
	 * @return Register
	 */
	public String toRegister() {
		return "/register.xhtml";
	}

	/**
	 * Wechsel zur login Seite
	 * 
	 * @return Login
	 */
	public String toLogin() {
		return "/login.xhtml";
	}

	/**
	 * Wechsel zur Film Liste.
	 * 
	 * @return Login
	 */
	public String toFilmListe() {
		return "/filmListe.xhtml";
	}

	/**
	 * Wechseln zum FilmFormular
	 * 
	 * @return Login
	 */
	public String toFilmFormular() {
		return "/secured/filmformular.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zur Suche Seite
	 * 
	 * @return Suche
	 */
	public String toSuche() {
		return "/such.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zur Film Seite
	 * 
	 * @return Film
	 */
	public String toFilm() {
		return "/film.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zum Film Update Seite
	 * 
	 * @return
	 */
	public String toFilmUpdate() {
		return "/secured/filmUpdate.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zur Index Seite
	 * 
	 * @return index
	 */
	public String toIndex() {
		return "/index.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zur alle Filme Seite
	 * 
	 * @return
	 */
	public String toAlleFilme() {
		return "/alleFilme.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zur eigene Filme Seite
	 * 
	 * @return
	 */
	public String toEigeneFilme() {
		return "/secured/eigeneFilme.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zur BenutzerVerwalten Seite
	 * 
	 * @return
	 */
	public String toBenutzerVerwalten() {
		return "/secured/benutzerVerwalten.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zur eigene Filme Seite
	 * 
	 * @return
	 */
	public String toKontakt() {
		return "/kontakt.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zu Über Uns
	 * 
	 * @return
	 */
	public String toUeberUns() {
		return "/ueberUns.xhtml?faces-redirect=true";
	}

	/**
	 * Wechsel zu Benutzer Verwalten
	 * 
	 * @return
	 */
	public String toBenutzerVerwaltung() {
		return "/secured/benutzerVerwalten.xhtml?faces-redirect=true";
	}

	/**
	 * Wechseln zum Adminbereich
	 * 
	 * @return
	 */
	public String toAdminBereich() {
		return "/secured/adminBereich.xhtml?faces-redirect=true";
	}

}
