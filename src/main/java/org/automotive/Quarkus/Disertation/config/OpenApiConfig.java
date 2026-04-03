package org.automotive.Quarkus.Disertation.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.OpenAPI;

@ApplicationScoped
public class OpenApiConfig {

    @Produces
    public OpenAPI customOpenAPI() {
        return OASFactory.createOpenAPI()
                .info(OASFactory.createInfo()
                        .title("Automotive Quarkus API")
                        .version("1.0.0")
                        .description("Automotive Management System built with Quarkus, Flyway, MySQL, Prometheus, and Grafana")
                );
    }
}