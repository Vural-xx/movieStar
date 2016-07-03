package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import Database.FilmDAO;
import comparator.FilmComparatorNameAZ;
import comparator.FilmComparatorNameZA;
import comparator.FilmComparatorNeusterFilm;
import comparator.FilmComparatorNeusterUpload;
import comparator.FilmComparatorNiedrigsteSterne;
import comparator.FilmComparatorAeltesterFilm;
import comparator.FilmComparatorAeltesterUpload;
import comparator.FilmComparatorHoechsteSterne;
import enums.FilmAuswahl;
import enums.Genre;
import interfaces.FilmFacade;
import model.Bewertung;
import model.Feld;
import model.Film;
import model.Filter;
import model.Kommentar;
import model.Mitwirkende;
import util.SortFilter;

/**
 * @author MacBook FilmController zur Verknüpfung der Filmansicht und der
 *         Filmdatenbank
 *
 */
@ManagedBean(name = "filmController")
@SessionScoped
public class FilmController implements FilmFacade {

	/**
	 * Film film
	 */
	private Film film;

	/**
	 * Double bewertungSterne
	 */
	private double bewertungSterne;
	/**
	 * Kommentar kommentar
	 */
	private Kommentar kommentar;
	/**
	 * List top10List
	 */
	private List top10List;
	/**
	 * Film wochenFilm
	 */
	private Film wochenFilm;
	/**
	 * FilmDAO filmDAO
	 */
	private FilmDAO filmDAO;
	/**
	 * SortFilter erzeugt
	 */
	SortFilter sortFilter = new SortFilter();
	/**
	 * BEnutzerController benutzerController
	 */

	@ManagedProperty(value = "#{BenutzerController}")
	private BenutzerController benutzerController;
	/**
	 * NavigationController navigationController
	 */
	@ManagedProperty(value = "#{navigationController}")
	private NavigationController navigationController;
	/**
	 * List filme
	 */
	private List filme;
	/**
	 * boolean filmBewertet default false
	 */
	private Boolean filmBewertet = false;
	/**
	 * List felder erzeugt
	 */
	private List<Feld> felder = new ArrayList<Feld>();

	/**
	 * Konstruktor des FilmControllers
	 */
	public FilmController() {
		filmDAO = new FilmDAO();
		navigationController = new NavigationController();
	}

	/**
	 * Getter von BewertungSterne
	 * 
	 * @return bewertungSterne
	 */
	public double getBewertungSterne() {
		return bewertungSterne;
	}

	/**
	 * Setter von BewertungSterne
	 * 
	 * @param bewertungSterne
	 */
	public void setBewertungSterne(double bewertungSterne) {
		this.bewertungSterne = bewertungSterne;
	}

	/**
	 * Getter des SortierungsFilter
	 * 
	 * @return sortFilter
	 */
	public SortFilter getSortFilter() {
		return sortFilter;
	}

	/**
	 * Setter des SortierungsFilter
	 * 
	 * @param sortFilter
	 */
	public void setSortFilter(SortFilter sortFilter) {
		this.sortFilter = sortFilter;
	}

	/**
	 * Getter vom BenutzerController
	 * 
	 * @return benutzerController
	 */
	public BenutzerController getBenutzerController() {
		return benutzerController;
	}

	/**
	 * Setter vom BenutzerController
	 * 
	 * @param benutzerController
	 */
	public void setBenutzerController(BenutzerController benutzerController) {
		this.benutzerController = benutzerController;
	}

	/**
	 * Getter von dem Film der Woche
	 * 
	 * @return wochenFilm
	 */
	public Film getWochenFilm() {
		return wochenFilm;
	}

	/**
	 * Setter von dem Film der Woche
	 * 
	 * @param wochenFilm
	 */
	public void setWochenFilm(Film wochenFilm) {
		this.wochenFilm = wochenFilm;
	}

	/**
	 * Getter der Top 10 Liste
	 * 
	 * @return top10List
	 */
	public List getTop10List() {
		return top10List;
	}

	/**
	 * Setter der Top 10 Liste
	 * 
	 * @param top10List
	 */
	public void setTop10List(List top10List) {
		this.top10List = top10List;
	}

	/**
	 * Getter von Film
	 * 
	 * @return film
	 */
	public Film getFilm() {
		return film;
	}

	/**
	 * Setter von Film
	 * 
	 * @param film
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	/**
	 * Getter vom NavigationController
	 * 
	 * @return navigationController
	 */
	public NavigationController getNavigationController() {
		return navigationController;
	}

	/**
	 * Setter vom NavigationController
	 * 
	 * @param navigationController
	 */
	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	/**
	 * getter Kommentare
	 * 
	 * @return
	 */
	public Kommentar getKommentar() {
		return kommentar;
	}

	/**
	 * setter Kommentare
	 * 
	 * @param kommentar
	 */
	public void setKommentar(Kommentar kommentar) {
		this.kommentar = kommentar;
	}

	/**
	 * Getter von Film Liste
	 * 
	 * @return
	 */
	public List getFilme() {
		return filme;
	}

	/**
	 * Setter von Film Liste
	 * 
	 * @param filme
	 */
	public void setFilme(List filme) {
		this.filme = filme;
	}

	/**
	 * Getter von Felder
	 * 
	 * @return
	 */
	public List<Feld> getFelder() {
		return felder;
	}

	/**
	 * Setter von Felder
	 * 
	 * @param felder
	 */
	public void setFelder(List<Feld> felder) {
		this.felder = felder;
	}

	/**
	 * getter von filmbewertet
	 * 
	 * @return
	 */

	public Boolean getFilmBewertet() {
		return filmBewertet;
	}

	/**
	 * Setter von Film bewertet
	 * 
	 * @param filmBewertet
	 */

	public void setFilmBewertet(Boolean filmBewertet) {
		this.filmBewertet = filmBewertet;
	}

	/**
	 * Erst wird überprüft ob der Film in der Datenbank existiert. Wenn nicht
	 * wird er gespeichert.
	 * 
	 * @param film
	 * @return
	 */
	@Override
	public String filmErstellen(Film film) {
		if (filmDAO.filmSuchenByKey(film.getName(), film.getErscheinungsjahr()) == null) {
			mitwirkendeZuFilmHinzufuegen();
			film.setUploaddatum(new Date());
			filmDAO.filmErstellen(film);
			return listeVorbereiten();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Der Film ist bereits vorhanden", null));
		return "";
		// TODO Auto-generated method stub
	}

	/**
	 * Methode zur Aktualisierung von Film
	 * 
	 * @param film
	 * @return
	 */
	public String filmUpdate(Film film) {
		mitwirkendeZuFilmHinzufuegen();
		filmDAO.filmUpdate(film);
		return listeVorbereiten();
	}

	/**
	 * Film wird über einen String gesucht
	 * 
	 * @param suche
	 * @return
	 */
	@Override
	public String filmSuchen(String suche) {
		filme = filmDAO.filmSuchen(suche);
		return navigationController.toSuche();
	}

	@Override
	public boolean filmSuchenErweitert(Film film) {
		return true;

	}

	/**
	 * film bewerten boolean
	 * 
	 * @param FID
	 * @param sterne
	 * @return
	 */
	@Override
	public boolean filmBewerten(Long FID, double sterne) {
		return true;

	}

	/**
	 * film kommentieren boolean
	 * 
	 * @param FID
	 * @param kommentar
	 * @return
	 */
	@Override
	public boolean filmKommentieren(Long FID, String kommentar) {
		return true;

	}

	@Override
	public boolean filmFiltern(Filter filter) {
		return true;

	}

	/**
	 * Methode zur Vorbereitung der Film Liste
	 * 
	 * @return
	 */
	public String filmVorbereiten() {
		this.film = new Film();
		this.felder = new ArrayList<Feld>();
		return navigationController.toFilmFormular();
	}

	/**
	 * Methode zur Vorbereitung der Liste der erstellten Filme
	 * 
	 * @return
	 */
	public String listeVorbereiten() {
		this.setFilme(filmDAO.filmFuerErsteller(benutzerController.getBenutzer()));
		return navigationController.toFilmListe();
	}

	/**
	 * Methode zur Genre Auswahl
	 * 
	 * @return items
	 */
	public SelectItem[] getGenreValues() {
		SelectItem[] items = new SelectItem[Genre.values().length];
		int i = 0;
		for (Genre g : Genre.values()) {
			items[i++] = new SelectItem(g, g.getLabel());
		}
		return items;
	}

	/**
	 * Methode zur Film Auswahl
	 * 
	 * @param name
	 * @param filmauswahl
	 * @return
	 */
	public String selectFilm(String name, int erscheinungsjahr, String filmauswahl) {
		film = null;
		film = filmDAO.filmSuchenByKey(name, erscheinungsjahr);
		felder = new ArrayList<Feld>();
		kommentar = new Kommentar();
		mitwirkendeZuFelderHinzufuegen();

		if (filmauswahl.equals(FilmAuswahl.FILM.toString())) {

			return navigationController.toFilm();

		} else if (filmauswahl.equals(FilmAuswahl.FILMUPDATE.toString())) {

			return navigationController.toFilmUpdate();
		}
		return "false";
	}

	@Override
	public String neusteFilme() {
		filme = null;
		filme = filmDAO.neusteFilme();
		return navigationController.toSuche();
	}

	@Override
	public List<Film> top10() {
		top10List = null;
		top10List = filmDAO.top10();
		if (top10List.size() != 0) {
			wochenFilm = filmDerWoche(top10List);
		}
		return top10List;
	}

	/**
	 * Gibt alle Filme wieder
	 * 
	 * @return
	 */
	@Override
	public String alleFilme() {
		filme = null;
		filme = filmDAO.alleFilme();
		return navigationController.toAlleFilme();
	}

	/**
	 * Methode um Mitwirkende einem Film hinzufügen
	 */
	public void mitwirkendeZuFilmHinzufuegen() {
		for (Feld f : felder) {
			Mitwirkende mitwirkende = new Mitwirkende();
			if (!f.getValue().equals("")) {
				mitwirkende.setName(f.getValue());
				if (!mitwirkenderBereitsVorhanden()) {
					film.getMitwirkende().add(mitwirkende);
				}
			}
		}
		felder = new ArrayList<Feld>();
	}

	/**
	 * HilfsMethode um Mitwirkende zum Felder hinzuzufügen
	 */
	public void mitwirkendeZuFelderHinzufuegen() {
		int counter = 0;
		for (Mitwirkende m : film.getMitwirkende()) {
			counter++;
			Feld feld = new Feld(counter + ".");
			feld.setValue(m.getName());
			felder.add(feld);
		}
	}

	/**
	 * Methode um den Film der Woche auszulesen
	 * 
	 * @param filme
	 * @return
	 */
	public Film filmDerWoche(List<Film> filme) {
		Random random = new Random();
		Film film = null;
		int i = random.nextInt(((filme.size() - 1) - 0) + 1) + 0;
		System.out.println(i);
		System.out.println(filme.get(i).getName());
		if (filme.get(i) != null) {
			film = filme.get(i);
		} else {
			film = filmDerWoche(top10List);
		}
		return film;
	}

	/**
	 * Dient zur sortierung der Filme über Comparatoren
	 * 
	 * @param sortiertyp
	 * @return
	 */
	@Override
	public String sortiereFilm(String sortiertyp) {

		switch (sortiertyp) {
		case "HOECHSTESTERNE":
			FilmComparatorHoechsteSterne filmComparatorHoechsteSterne = new FilmComparatorHoechsteSterne();

			sortFilter.sterneBool(true);
			filme.sort(filmComparatorHoechsteSterne);
			break;
		case "NIEDRIGSTESTERNE":
			FilmComparatorNiedrigsteSterne filmComparatorNiedrigsteSterne = new FilmComparatorNiedrigsteSterne();
			sortFilter.sterneBool(false);
			filme.sort(filmComparatorNiedrigsteSterne);
			break;
		case "NEUSTERFILM":
			FilmComparatorNeusterFilm filmComparatorNeusterFilm = new FilmComparatorNeusterFilm();
			sortFilter.erscheinungsjahrBool(true);
			filme.sort(filmComparatorNeusterFilm);
			break;
		case "AELTESTERFILM":
			FilmComparatorAeltesterFilm filmComparatorAeltesterFilm = new FilmComparatorAeltesterFilm();
			sortFilter.erscheinungsjahrBool(false);
			filme.sort(filmComparatorAeltesterFilm);
			break;
		case "NAMEAZ":
			FilmComparatorNameAZ filmComparatorNameAZ = new FilmComparatorNameAZ();
			sortFilter.nameBool(true);
			filme.sort(filmComparatorNameAZ);
			break;
		case "NAMEZA":
			FilmComparatorNameZA filmComparatorNameZA = new FilmComparatorNameZA();
			sortFilter.nameBool(false);
			filme.sort(filmComparatorNameZA);
			break;
		case "AELTESTERUPLOAD":
			FilmComparatorNeusterUpload filmComparatorNeusterUpload = new FilmComparatorNeusterUpload();
			sortFilter.uploadBool(false);
			filme.sort(filmComparatorNeusterUpload);
			break;
		case "NEUSTERUPLOAD":
			FilmComparatorAeltesterUpload filmComparatorAeltesterUpload = new FilmComparatorAeltesterUpload();
			sortFilter.uploadBool(true);
			filme.sort(filmComparatorAeltesterUpload);
			break;

		default:
			break;
		}

		return navigationController.toAlleFilme();
	}

	/**
	 * Methode um die Mitwirkende eines Films zu bekommen
	 * 
	 * @return
	 */
	public String getMitwirkende() {
		String mitwirkende = "";
		if (film.getMitwirkende() != null) {
			for (Mitwirkende a : film.getMitwirkende()) {
				if (mitwirkende != "") {
					mitwirkende = mitwirkende + ", ";
				}
				if (a.getVorname() != null && a.getName() != null) {
					mitwirkende = mitwirkende + a.getVorname() + a.getName();
				} else if (a.getName() == null) {
					mitwirkende = mitwirkende + a.getVorname();
				} else if (a.getVorname() == null) {
					mitwirkende = mitwirkende + a.getName();
				}

			}
		}
		return mitwirkende;
	}

	/**
	 * Methode zum Film bewerten
	 * 
	 * @return
	 */

	@Override
	public String bewerteFilm() {
		Bewertung bewertung = new Bewertung();
		bewertung.setErsteller(benutzerController.getBenutzer());
		bewertung.setSterne(bewertungSterne);
		film.getBewertungen().add(bewertung);
		filmDAO.bewerteFilm(bewertung, film);
		film = filmDAO.filmSuchenByKey(film.getName(), film.getErscheinungsjahr());
		return navigationController.toFilm();
	}

	/**
	 * Methode zum Film löschen
	 * 
	 * @param film
	 * @return
	 */
	@Override
	public boolean filmLoeschen(Film film) {
		if (filmDAO.filmLoeschen(film)) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt alle Filme des Erstellers wieder
	 * 
	 * @return
	 */
	public String filmFuerErsteller() {
		filme = filmDAO.filmFuerErsteller(benutzerController.getBenutzer());
		return navigationController.toEigeneFilme();
	}

	/**
	 * boolean zur Prüfung, ob Mitwirkende bereits vorhanden sind
	 * 
	 * @return
	 */
	public boolean mitwirkenderBereitsVorhanden() {
		for (Mitwirkende m : film.getMitwirkende()) {
			for (Feld f : felder) {
				if (m.getName().equals(f.getValue())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Methode für das hinzufügen von Kommentaren
	 * 
	 * @return
	 */

	public String kommentarHinzufuegen() {
		kommentar.setErsteller(benutzerController.getBenutzer());
		film.getKommentare().add(kommentar);
		filmDAO.filmKommentieren(kommentar, film);
		return navigationController.toAlleFilme();
	}

	/**
	 * prüft ob der Benutzer den film bereichts bewertet hat
	 * 
	 * @return
	 */
	@Override
	public boolean filmBereitsBewertet() {
		filmBewertet = filmDAO.filmBereitsBewertet(benutzerController.getBenutzer(), film);
		return filmBewertet;
	}

}
