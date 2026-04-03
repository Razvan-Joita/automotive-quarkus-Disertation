package org.automotive.Quarkus.Disertation.exceptions;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.Map;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        int status = 500;
        if (exception instanceof ResourceNotFoundException) {
            status = 404;
        }

        return Response.status(status)
                .type(MediaType.APPLICATION_JSON)
                .entity(Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", status,
                        "message", exception.getMessage()
                ))
                .build();
    }
}