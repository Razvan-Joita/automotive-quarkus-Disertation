package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.dtos.UserDTO;
import org.automotive.Quarkus.Disertation.mappers.UserMapper;
import org.automotive.Quarkus.Disertation.models.User;
import org.automotive.Quarkus.Disertation.services.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Users")
@RolesAllowed("ADMIN")
public class UserResource {

    @Inject
    UserService service;

    @Inject
    UserMapper mapper;

    @GET
    @Operation(summary = "Get all users")
    public List<UserDTO> getAll() {
        return service.findAll().stream().map(mapper::toDto).toList();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get user by id")
    public UserDTO getById(@PathParam("id") Long id) {
        return mapper.toDto(service.findById(id));
    }

    @POST
    @Operation(summary = "Create user")
    public User create(User entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update user")
    public User update(@PathParam("id") Long id, User entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete user")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}