package assignments.restservice.providers;

import assignments.restservice.beans.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServerExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        ErrorMessage em = new ErrorMessage();
        em.setCode(500);
        em.setMessage("Internal server error");

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(em)
                .build();
    }
}
