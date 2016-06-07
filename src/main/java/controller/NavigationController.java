package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationController  {
	
     
    /**
     * Go to register page.
     * @return Register page name.
     */
    public String toRegister() {
        return "/register.xhtml";
    }
    
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "/login.xhtml";
    }
    
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toFilmListe() {
        return "/filmListe.xhtml";
    }
    
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toFilmFormular() {
        return "/filmformular?faces-redirect=true";
    }
    /**
     * Go to such page
     * @return String suche
     */
    public String toSuche(){
    	return "/such.xhtml";
    }


}
