package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
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
import enums.SortierTyp;
import interfaces.FilmFacade;
import model.Bewertung;
import model.Feld;
import model.Film;
import model.Filter;
import model.Mitwirkende;
import util.SortFilter;

@ManagedBean(name = "filmController")
@SessionScoped
public class FilmController implements FilmFacade {

	private Film film;
	private double bewertungSterne;

	public double getBewertungSterne() {
		return bewertungSterne;
	}

	public void setBewertungSterne(double bewertungSterne) {
		this.bewertungSterne = bewertungSterne;
	}

	private List top10List;
	private Film wochenFilm;
	private FilmDAO filmDAO;
	SortFilter sortFilter = new SortFilter();

	public SortFilter getSortFilter() {
		return sortFilter;
	}

	public void setSortFilter(SortFilter sortFilter) {
		this.sortFilter = sortFilter;
	}

	@ManagedProperty(value = "#{BenutzerController}")
	private BenutzerController benutzerController;

	public BenutzerController getBenutzerController() {
		return benutzerController;
	}

	public void setBenutzerController(BenutzerController benutzerController) {
		this.benutzerController = benutzerController;
	}

	@ManagedProperty(value = "#{navigationController}")
	private NavigationController navigationController;
	private List filme;
	private List<Feld> felder = new ArrayList<Feld>();

	public FilmController() {
		filmDAO = new FilmDAO();
		navigationController = new NavigationController();
	}

	public Film getWochenFilm() {
		return wochenFilm;
	}

	public void setWochenFilm(Film wochenFilm) {
		this.wochenFilm = wochenFilm;
	}

	public List getTop10List() {
		return top10List;
	}

	public void setTop10List(List top10List) {
		this.top10List = top10List;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	@Override
	public String filmErstellen(Film film) {
		mitwirkendeZuFilmHinzufuegen();
		film.setUploaddatum(new Date());
		filmDAO.filmErstellen(film);
		return listeVorbereiten();
		// TODO Auto-generated method stub

	}

	public String filmUpdate(Film film) {
		mitwirkendeZuFilmHinzufuegen();
		filmDAO.filmUpdate(film);
		return listeVorbereiten();
		// TODO Auto-generated method stub

	}

	@Override
	public String filmSuchen(String suche) {
		filme = filmDAO.filmSuchen(suche);
		return navigationController.toSuche();

	}

	@Override
	public void filmSuchenErweitert(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public void filmBewerten(Long FID, double sterne) {
		// TODO Auto-generated method stub

	}

	@Override
	public void filmKommentieren(Long FID, String kommentar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void filmFiltern(Filter filter) {
		// TODO Auto-generated method stub

	}

	public String filmVorbereiten() {
		this.film = new Film();
		return navigationController.toFilmFormular();
	}

	public String listeVorbereiten() {
		this.setFilme(filmDAO.filmFuerErsteller(benutzerController.getBenutzer()));
		return navigationController.toFilmListe();
	}

	public List getFilme() {
		return filme;
	}

	public void setFilme(List filme) {
		this.filme = filme;
	}

	public SelectItem[] getGenreValues() {
		SelectItem[] items = new SelectItem[Genre.values().length];
		int i = 0;
		for (Genre g : Genre.values()) {
			items[i++] = new SelectItem(g, g.getLabel());
		}
		return items;
	}

	public String selectFilm(String name, String filmauswahl) {
		film = filmDAO.filmSuchenByName(name);
		mitwirkendeZuFelderHinzufuegen();
		System.out.println(FilmAuswahl.FILM);
		System.out.println(filmauswahl);
		if (filmauswahl.equals(FilmAuswahl.FILM.toString())) {
			return navigationController.toFilm();

		} else if (filmauswahl.equals(FilmAuswahl.FILMUPDATE.toString())) {
			return navigationController.toFilmUpdate();
		}
		return "false";
	}

	public List<Feld> getFelder() {
		return felder;
	}

	public void setFelder(List<Feld> felder) {
		this.felder = felder;
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
		if(top10List.size() != 0){
			wochenFilm = filmDerWoche(top10List);
		}
		return top10List;
	}

	@Override
	public String alleFilme() {
		filme = null;
		filme = filmDAO.alleFilme();
		return navigationController.toAlleFilme();
	}

	public void mitwirkendeZuFilmHinzufuegen() {
		for (Feld f : felder) {
			Mitwirkende mitwirkende = new Mitwirkende();
			if (!f.getValue().equals("")) {
				mitwirkende.setName(f.getValue());
				film.getMitwirkende().add(mitwirkende);
			}
		}
		felder = new ArrayList<Feld>();

	}

	public void mitwirkendeZuFelderHinzufuegen() {
		int counter = 0;
		for (Mitwirkende m : film.getMitwirkende()) {
			counter++;
			Feld feld = new Feld(counter + ".");
			feld.setValue(m.getName());
			felder.add(feld);
		}
	}

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

	@Override
	public String bewerteFilm() {
		Bewertung bewertung = new Bewertung();
		bewertung.setErsteller(benutzerController.getBenutzer());
		bewertung.setSterne(bewertungSterne);
		filmDAO.bewerteFilm(bewertung, film);
		return navigationController.toFilm();
	}

	@Override
	public boolean filmLoeschen(Film film) {
		if(filmDAO.filmLoeschen(film)){
			return true;
		}
		return false;
	}
	
	public String filmFuerErsteller(){
		filme =filmDAO.filmFuerErsteller(benutzerController.getBenutzer());
		return navigationController.toEigeneFilme();
	}
	
	

}
