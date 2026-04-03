package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.dtos.CustomerDTO;
import org.automotive.Quarkus.Disertation.mappers.CustomerMapper;
import org.automotive.Quarkus.Disertation.services.CustomerService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Customers")
public class CustomerResource {

    @Inject
    CustomerService service;

    @Inject
    CustomerMapper mapper;

    @GET
    @Operation(summary = "Get all customers")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<CustomerDTO> getAll() {
        return service.findAll().stream().map(mapper::toDto).toList();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get customer by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public CustomerDTO getById(@PathParam("id") Long id) {
        return mapper.toDto(service.findById(id));
    }

    @POST
    @Operation(summary = "Create customer")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public CustomerDTO create(CustomerDTO dto) {
        return mapper.toDto(service.create(mapper.toEntity(dto)));
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update customer")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public CustomerDTO update(@PathParam("id") Long id, CustomerDTO dto) {
        return mapper.toDto(service.update(id, mapper.toEntity(dto)));
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete customer")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}