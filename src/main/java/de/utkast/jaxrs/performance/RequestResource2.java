package de.utkast.jaxrs.performance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Florian Hirsch
 */
@Path("/request-2")
public class RequestResource2 {

	@Context
	private UriInfo uriInfo;
	
	@GET
	public Response get(@QueryParam("q") String query) {
		return Response.ok(String.format("You queried for %s. Absolute path is %s", query, uriInfo.getAbsolutePath())).build();
	}
	
}
