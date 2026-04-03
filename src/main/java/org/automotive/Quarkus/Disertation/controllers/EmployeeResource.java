package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.models.Employee;
import org.automotive.Quarkus.Disertation.services.EmployeeService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Employees")
public class EmployeeResource {

    @Inject
    EmployeeService service;

    @GET
    @Operation(summary = "Get all employees")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<Employee> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get employee by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public Employee getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create employee")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Employee create(Employee entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update employee")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Employee update(@PathParam("id") Long id, Employee entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete employee")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}