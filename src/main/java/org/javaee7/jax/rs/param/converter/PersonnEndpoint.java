package org.javaee7.jax.rs.param.converter;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/personn")
@Produces(PageAttributes.MediaType.APPLICATION_JSON)
public class PersonnEndpoint {


    @GET
    public Response get(Personn personn) {
        return Response.ok().build();
    }

}
