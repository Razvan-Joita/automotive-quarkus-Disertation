package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.dtos.DealershipDTO;
import org.automotive.Quarkus.Disertation.mappers.DealershipMapper;
import org.automotive.Quarkus.Disertation.services.DealershipService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/dealerships")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Dealerships")
public class DealershipResource {

    @Inject
    DealershipService service;

    @Inject
    DealershipMapper mapper;

    @GET
    @Operation(summary = "Get all dealerships")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<DealershipDTO> getAll() {
        return service.findAll().stream().map(mapper::todto).toList();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get dealership by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public DealershipDTO getById(@PathParam("id") Long id) {
        return mapper.todto(service.findById(id));
    }

    @POST
    @Operation(summary = "Create dealership")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public DealershipDTO create(DealershipDTO dto) {
        return mapper.todto(service.create(mapper.toEntity(dto)));
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update dealership")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public DealershipDTO update(@PathParam("id") Long id, DealershipDTO dto) {
        return mapper.todto(service.update(id, mapper.toEntity(dto)));
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete dealership")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}