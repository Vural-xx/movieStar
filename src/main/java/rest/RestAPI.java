package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class RestAPI {

	@GET
	public String sayHello() {
		return "Hello";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON() {
		return "{'hello':'Hello'}";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String sayHelloXML() {
		return "<hello>hello</hello>";
	}

}
