package assignments.restservice.providers;

import assignments.restservice.beans.ErrorMessage;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(NotFoundException e) {
        ErrorMessage em = new ErrorMessage();
        em.setCode(e.getResponse().getStatus());
        em.setMessage(e.getMessage());

        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(em)
                .build();
    }
}
