package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.models.Vehicle;
import org.automotive.Quarkus.Disertation.services.VehicleService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Vehicles")
public class VehicleResource {

    @Inject
    VehicleService service;

    @GET
    @Operation(summary = "Get all vehicles")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<Vehicle> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get vehicle by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public Vehicle getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create vehicle")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Vehicle create(Vehicle entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update vehicle")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Vehicle update(@PathParam("id") Long id, Vehicle entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete vehicle")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}