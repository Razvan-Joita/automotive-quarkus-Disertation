package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Dealership;

import java.util.List;

public interface DealershipService {
    List<Dealership> findAll();

    Dealership findById(Long id);

    Dealership create(Dealership dealership);

    Dealership update(Long id, Dealership dealership);

    void delete(Long id);
}