package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Vehicle;
import org.automotive.Quarkus.Disertation.repositories.VehicleRepository;
import org.automotive.Quarkus.Disertation.services.VehicleService;

import java.util.List;

@ApplicationScoped
public class VehicleServiceImpl implements VehicleService {

    @Inject
    VehicleRepository repository;

    @Override
    public List<Vehicle> findAll() {
        return repository.listAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id " + id));
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle vehicle) {
        repository.persist(vehicle);
        return vehicle;
    }

    @Override
    @Transactional
    public Vehicle update(Long id, Vehicle vehicle) {
        Vehicle existing = findById(id);
        existing.vin = vehicle.vin;
        existing.licensePlate = vehicle.licensePlate;
        existing.make = vehicle.make;
        existing.model = vehicle.model;
        existing.year = vehicle.year;
        existing.fuelType = vehicle.fuelType;
        existing.status = vehicle.status;
        existing.manufacturer = vehicle.manufacturer;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}