package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class RestAPI {
	
	@GET
	public String sayHello(){
		return "Hello";
	}

}
