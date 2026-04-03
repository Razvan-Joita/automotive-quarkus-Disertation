package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.models.Warranty;
import org.automotive.Quarkus.Disertation.services.WarrantyService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/warranties")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Warranties")
public class WarrantyResource {

    @Inject
    WarrantyService service;

    @GET
    @Operation(summary = "Get all warranties")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<Warranty> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get warranty by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public Warranty getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create warranty")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Warranty create(Warranty entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update warranty")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Warranty update(@PathParam("id") Long id, Warranty entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete warranty")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}