package assignments.restservice.providers;

import assignments.restservice.beans.ErrorMessage;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(ConstraintViolationException e) {
        ErrorMessage em = new ErrorMessage();
        em.setCode(400);
        em.setMessage(e.getConstraintViolations().iterator().next().getMessage());

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(em)
                .build();
    }
}
