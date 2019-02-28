package assignments.restservice.providers;

import assignments.restservice.beans.ErrorMessage;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoContentExceptionMapper implements ExceptionMapper<NoContentException> {
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(NoContentException e) {
        ErrorMessage em = new ErrorMessage();
        em.setCode(200);
        em.setMessage(e.getMessage());

        return Response
                .status(Response.Status.OK)
                .entity(em)
                .build();
    }
}
