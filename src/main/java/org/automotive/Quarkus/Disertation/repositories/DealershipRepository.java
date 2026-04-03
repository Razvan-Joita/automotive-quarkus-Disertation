package org.automotive.Quarkus.Disertation.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.models.Dealership;

@ApplicationScoped
public class DealershipRepository implements PanacheRepository<Dealership> {
}