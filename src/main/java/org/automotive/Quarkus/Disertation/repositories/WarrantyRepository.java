package org.automotive.Quarkus.Disertation.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.models.Warranty;

@ApplicationScoped
public class WarrantyRepository implements PanacheRepository<Warranty> {
}