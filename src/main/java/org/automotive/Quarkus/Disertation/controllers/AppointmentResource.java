package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.models.Appointment;
import org.automotive.Quarkus.Disertation.services.AppointmentService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Appointments")
public class AppointmentResource {

    @Inject
    AppointmentService service;

    @GET
    @Operation(summary = "Get all appointments")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<Appointment> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get appointment by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public Appointment getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create appointment")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Appointment create(Appointment entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update appointment")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Appointment update(@PathParam("id") Long id, Appointment entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete appointment")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}