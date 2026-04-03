package org.automotive.Quarkus.Disertation.controllers;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.automotive.Quarkus.Disertation.models.Invoice;
import org.automotive.Quarkus.Disertation.services.InvoiceService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/v1/invoices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Invoices")
public class InvoiceResource {

    @Inject
    InvoiceService service;

    @GET
    @Operation(summary = "Get all invoices")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public List<Invoice> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get invoice by id")
    @RolesAllowed({"ADMIN", "MANAGER", "USER"})
    public Invoice getById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create invoice")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Invoice create(Invoice entity) {
        return service.create(entity);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update invoice")
    @RolesAllowed({"ADMIN", "MANAGER"})
    public Invoice update(@PathParam("id") Long id, Invoice entity) {
        return service.update(id, entity);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete invoice")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}