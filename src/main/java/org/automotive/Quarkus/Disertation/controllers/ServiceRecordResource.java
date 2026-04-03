package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.models.ServiceRecord;
import org.automotive.Quarkus.Disertation.services.ServiceRecordService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/service-records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Service Records")
public class ServiceRecordResource {

    @Inject
    ServiceRecordService service;

    @GET
    @Operation(summary = "Get all service records")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<ServiceRecord> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get service record by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public ServiceRecord getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create service record")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public ServiceRecord create(ServiceRecord entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update service record")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public ServiceRecord update(@PathParam("id") Long id, ServiceRecord entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete service record")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}