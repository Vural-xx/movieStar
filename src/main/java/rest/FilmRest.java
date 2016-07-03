package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import model.Benutzer;
import model.Film;

/**
 * @author MacBook Klasse RestFilme
 *
 */
@Path("filme")
public class FilmRest {

	public static List<Film> filme = new ArrayList<Film>();

	/**
	 * Methode um Filme zu füllen
	 */
	private void fillFilme() {
		if (filme.size() == 0) {
			Film film1 = new Film();
			film1.setName("Casablanca");
			film1.setBeschreibung("Noir Film");
			Film film2 = new Film();
			film2.setName("Spiderman");
			film2.setBeschreibung("Action");
			filme.add(film1);
			filme.add(film2);
		}
	}

	/**
	 * Methode um Filme zu bekommen
	 * 
	 * @return
	 */
	@GET
	public String getFilme() {
		fillFilme();
		Gson gson = new Gson();
		return gson.toJson(filme);
	}

	/**
	 * Methode um Filme zu bekommen
	 * 
	 * @param filmid
	 * @return
	 */
	@GET
	@Path("{id}")
	public String getFilm(@PathParam("id") Long filmid) {
		fillFilme();
		Gson gson = new Gson();
		for (Film f : filme) {
			// if(f.getId() == filmid){
			return gson.toJson(f);
			// }
		}
		return keinErgebnisse();

	}

	/**
	 * Methode um Filme zu erstellen
	 * 
	 * @param name
	 * @param beschreibung
	 * @return
	 */
	@POST
	public Response createFilm(@FormParam("name") String name, @FormParam("beschreibung") String beschreibung) {
		fillFilme();
		Film film = new Film();
		// film.setId(Long.valueOf(filme.size()));
		film.setName(name);
		film.setBeschreibung(beschreibung);
		return Response.status(200).build();
	}

	@DELETE
	public Response deleteUser(@FormParam("name") String name) {
		fillFilme();
		for (Film f : filme) {
			if (f.getName().equals(name)) {
				filme.remove(f);
				return Response.status(200).build();
			}
		}
		return Response.status(200).entity("Nichts zum löschen gefunden").build();
	}

	public String keinErgebnisse() {
		return "{'data': 'Keine Ergebnisse gefunden'}";
	}

}
