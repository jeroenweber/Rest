package assignments.restservice.services;

import assignments.restservice.beans.House;
import assignments.restservice.beans.HouseResponse;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Collections;

@Path("/houses")
public class HouseRegistrationService {
    @Context
    UriInfo uri;

    private HouseResponse resp = new HouseResponse();

    @GET
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHouseByID(@PathParam("id") int id) {
        resp.setResult(Collections.singletonList(House.findHouseByID(id)));
        if (resp.getResult().get(0) == null) throw new NotFoundException("No house found with provided ID");
        return Response.ok(resp).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHouses() throws NoContentException {
        resp.setResult(House.getAll());
        if (resp.getResult().isEmpty()) throw new NoContentException("No houses registered in the system");
        return Response.ok(resp).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerHouse(@Valid House h) {
    	System.out.println("House: " + h);
        resp.setCreatedSource(String.format("%s/%s", uri.getAbsolutePath(), House.putHouse(h).getId()));
        return Response.status(Response.Status.CREATED).entity(resp).build();
    }

    @PUT
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateHouse(@Valid House h, @PathParam("id") int id) {
        if (House.findHouseByID(id) == null) throw new NotFoundException("No house found with provided ID");
        if (House.putHouse(id, h) == null) throw new BadRequestException("Values provider incorrect or not correspond");
        return Response.ok(resp).build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteHouse(@PathParam("id") int id) {
        if (House.findHouseByID(id) == null) throw new NotFoundException("No house found with provided ID");
        House.deleteHouse(id);
        return Response.ok(resp).build();
    }
    
}