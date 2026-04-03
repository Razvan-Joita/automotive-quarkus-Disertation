package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.models.Part;
import org.automotive.Quarkus.Disertation.services.PartService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/parts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Parts")
public class PartResource {

    @Inject
    PartService service;

    @GET
    @Operation(summary = "Get all parts")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<Part> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get part by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public Part getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create part")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Part create(Part entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update part")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Part update(@PathParam("id") Long id, Part entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete part")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}