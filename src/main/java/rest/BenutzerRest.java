package rest;

import java.nio.file.attribute.UserPrincipalNotFoundException;
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
 * @author MacBook Klasse RestBenutzer
 *
 */
@Path("/benutzer")
public class BenutzerRest {
	public static List<Benutzer> benutzers = new ArrayList<Benutzer>();

	/**
	 * Rest zum Benutzer füllen
	 */
	private void fillBenutzer() {
		if (benutzers.size() == 0) {
			benutzers = new ArrayList<Benutzer>();
			Benutzer benutzer = new Benutzer();
			// benutzer.setId(1L);
			benutzer.setBenutzername("test1");
			Film film = new Film();
			// film.setId(1L);
			film.setName("Casablanca");
			Film film2 = new Film();
			// film2.setId(2L);
			film2.setName("Scarface");
			List<Film> filme = new ArrayList<Film>();
			filme.add(film);
			filme.add(film2);
			// benutzer.setErstellteFilme(filme);
			benutzers.add(benutzer);

			Benutzer benutzer1 = new Benutzer();
			// benutzer1.setId(2L);
			benutzer1.setBenutzername("test2");
			Film film3 = new Film();
			// film3.setId(3L);
			film3.setName("Spiderman");
			Film film4 = new Film();
			// film4.setId(4L);
			film4.setName("Superman");
			List<Film> filme2 = new ArrayList<Film>();
			filme2.add(film3);
			filme2.add(film4);
			// benutzer1.setErstellteFilme(filme2);
			benutzers.add(benutzer1);
		}
	}

	/**
	 * Methode um den Benutzer zu erhalten
	 * 
	 * @return
	 */
	@GET
	public String getUsersJson() {
		fillBenutzer();
		Gson gson = new Gson();
		return gson.toJson(benutzers);
	}

	/**
	 * Methode um den Benutzer zu erhalten
	 * 
	 * @param userid
	 * @return
	 */
	@GET
	@Path("{id}")
	public String getUserJson(@PathParam("id") Long userid) {
		fillBenutzer();
		Gson gson = new Gson();
		for (Benutzer b : benutzers) {
			// if(b.getId() == userid){
			return gson.toJson(b);
			// }
		}
		return keinErgebnisse();

	}

	/**
	 * Methode um einem Film zu suchen
	 * 
	 * @param userid
	 * @return
	 */
	@GET
	@Path("{id}/filme")
	public String getUserMovies(@PathParam("id") Long userid) {
		fillBenutzer();
		Gson gson = new Gson();
		for (Benutzer b : benutzers) {
			// if(b.getId() == userid){
			// return gson.toJson(b.getErstellteFilme());
			// }
		}
		return keinErgebnisse();
	}

	/**
	 * Methode um einem Film zu suchen
	 * 
	 * @param userid
	 * @param filmId
	 * @return
	 */
	@GET
	@Path("{id}/filme/{filmid}")
	public String getUserMovies(@PathParam("id") Long userid, @PathParam("filmid") Long filmId) {
		fillBenutzer();
		Gson gson = new Gson();
		for (Benutzer b : benutzers) {
			// if(b.getId() == userid){
			// for(Film f: b.getErstellteFilme()){
			// if(f.getId() == filmId){
			// return gson.toJson(f);
			// }
			// }
			// }
		}
		return keinErgebnisse();
	}

	/**
	 * POST Methode um einen Benutzer zu erstellen
	 * 
	 * @param name
	 * @param email
	 * @return
	 */
	@POST
	public Response createUser(@FormParam("name") String name, @FormParam("email") String email) {
		fillBenutzer();
		Benutzer benutzer = new Benutzer();
		// benutzer.setId(Long.valueOf(benutzers.size()));
		benutzer.setBenutzername(name);
		benutzer.setEmail(email);
		benutzers.add(benutzer);
		return Response.status(200).build();
	}

	/**
	 * DELETE Methode um einen Benutzer zu löschen
	 * 
	 * @param name
	 * @return
	 */
	@DELETE
	public Response deleteUser(@FormParam("name") String name) {
		fillBenutzer();
		for (Benutzer b : benutzers) {
			if (b.getBenutzername().equals(name)) {
				benutzers.remove(b);
				return Response.status(200).build();
			}
		}
		return Response.status(200).entity("Nichts zum löschen gefunden").build();
	}

	public String keinErgebnisse() {
		return "{'data': 'Keine Ergebnisse gefunden'}";
	}
}
