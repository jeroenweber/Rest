package assignments.restservice.providers;

import assignments.restservice.beans.ErrorMessage;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(BadRequestException e) {
        ErrorMessage em = new ErrorMessage();
        em.setCode(400);
        em.setMessage(e.getMessage());

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(em)
                .build();
    }
}
