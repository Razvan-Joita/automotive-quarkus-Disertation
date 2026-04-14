package org.automotive.Quarkus.Disertation.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class TestResource {

    @GET
    public String test() {
        return "OK";
    }
}