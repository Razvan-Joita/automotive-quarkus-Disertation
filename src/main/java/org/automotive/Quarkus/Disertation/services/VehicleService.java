package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();

    Vehicle findById(Long id);

    Vehicle create(Vehicle vehicle);

    Vehicle update(Long id, Vehicle vehicle);

    void delete(Long id);
}