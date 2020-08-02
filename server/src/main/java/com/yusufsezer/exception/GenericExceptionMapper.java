package com.yusufsezer.exception;

import com.yusufsezer.model.ErrorMessage;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {
        Status status = Response.Status.INTERNAL_SERVER_ERROR;
        ErrorMessage errorMessage = new ErrorMessage(
                "6.6.1",
                status.getReasonPhrase(),
                500);

        if (ex instanceof WebApplicationException) {
            WebApplicationException wae = (WebApplicationException) ex;
            Response.StatusType statusInfo = wae.getResponse().getStatusInfo();
            errorMessage.setTitle(statusInfo.getReasonPhrase());
            errorMessage.setStatus(statusInfo.getStatusCode());
        }

        if (ex instanceof ProcessingException) {
            ProcessingException pe = (ProcessingException) ex;
            errorMessage.setTitle(ex.getMessage());
            errorMessage.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
            errorMessage.setType("6.5.1");
        }

        return Response
                .status(errorMessage.getStatus())
                .entity(errorMessage)
                .build();
    }

}
