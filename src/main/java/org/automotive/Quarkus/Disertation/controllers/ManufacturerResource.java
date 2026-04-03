package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.dtos.ManufacturerDTO;
import org.automotive.Quarkus.Disertation.mappers.ManufacturerMapper;
import org.automotive.Quarkus.Disertation.services.ManufacturerService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/manufacturers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Manufacturers")
public class ManufacturerResource {

    @Inject
    ManufacturerService service;

    @Inject
    ManufacturerMapper mapper;

    @GET
    @Operation(summary = "Get all manufacturers")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<ManufacturerDTO> getAll() {
        return service.findAll().stream().map(mapper::toDto).toList();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get manufacturer by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public ManufacturerDTO getById(@PathParam("id") Long id) {
        return mapper.toDto(service.findById(id));
    }

    @POST
    @Operation(summary = "Create manufacturer")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public ManufacturerDTO create(ManufacturerDTO dto) {
        return mapper.toDto(service.create(mapper.toEntity(dto)));
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update manufacturer")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public ManufacturerDTO update(@PathParam("id") Long id, ManufacturerDTO dto) {
        return mapper.toDto(service.update(id, mapper.toEntity(dto)));
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete manufacturer")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}