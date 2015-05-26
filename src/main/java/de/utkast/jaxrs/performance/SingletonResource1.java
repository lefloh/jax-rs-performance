package de.utkast.jaxrs.performance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author Florian Hirsch
 */
@Path("/singleton-1")
public class SingletonResource1 {

	@GET
	public Response get(@QueryParam("q") String query) {
		return Response.ok(String.format("You queried for %s", query)).build();
	}
	
}
