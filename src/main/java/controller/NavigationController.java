package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author MacBook
 *
 */
@ManagedBean
@SessionScoped
public class NavigationController  {
	
     
    /**
     * Wechsel zur Register Seite
     * @return Register
     */
    public String toRegister() {
        return "/register.xhtml";
    }
    
    /**
     * Wechsel zur login Seite
     * @return Login 
     */
    public String toLogin() {
        return "/login.xhtml";
    }
    
    /**
     * Wechsel zur Film Liste.
     * @return Login
     */
    public String toFilmListe() {
        return "/filmListe.xhtml";
    }
    
    /**
     * Wechseln zum FilmFormular
     * @return Login 
     */
    public String toFilmFormular() {
        return "/secured/filmformular?faces-redirect=true";
    }
    /**
     * Wechsel zur Suche Seite
     * @return Suche
     */
    public String toSuche(){
    	return "/such.xhtml";
    }
    
    /**
     * Wechsel zur Film Seite
     * @return Film
     */
    public String toFilm(){
    	return "/film.xhtml";
    }
    
    /**
     * Wechsel zum Film Update Seite
     * @return
     */
    public String toFilmUpdate() {
    	return "/secured/filmUpdate.xhtml";
    }
    
    /**
     * Wechsel zur Index Seite
     * @return index
     */
    public String toIndex() {
    	return "/index.xhtml";
    }
 

    /**
     * Wechsel zur alle Filme Seite 
     * @return
     */
    public String toAlleFilme(){
    	return "/alleFilme.xhtml";
    }
    
    /**
     * Wechsel zur eigene Filme Seite
     * @return
     */
    public String toEigeneFilme(){
    	return "/secured/eigeneFilme.xhtml";
    }
    
    /**
     * Wechsel zur BenutzerVerwalten Seite
     * @return
     */
    public String toBenutzerVerwalten(){
    	return "/secured/benutzerVerwalten.xhtml";
    }
    
    /**
     * Wechsel zur eigene Filme Seite
     * @return
     */
    public String toKontakt(){
    	return "/kontakt.xhtml";
    }
    
    public String toUeberUns(){
    	return "/ueberUns.xhtml";
    }
    
    public String toBenutzerVerwaltung(){
    	return "/secured/benutzerVerwalten.xhtml";
    }
    
    public String toAdminBereich(){
    	return "/secured/adminBereich.xhtml";
    }
    
   
  

}
