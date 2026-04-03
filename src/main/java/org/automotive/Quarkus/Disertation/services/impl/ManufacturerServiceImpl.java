package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Manufacturer;
import org.automotive.Quarkus.Disertation.repositories.ManufacturerRepository;
import org.automotive.Quarkus.Disertation.services.ManufacturerService;

import java.util.List;

@ApplicationScoped
public class ManufacturerServiceImpl implements ManufacturerService {

    @Inject
    ManufacturerRepository repository;

    @Override
    public List<Manufacturer> findAll() {
        return repository.listAll();
    }

    @Override
    public Manufacturer findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found with id " + id));
    }

    @Override
    @Transactional
    public Manufacturer create(Manufacturer manufacturer) {
        repository.persist(manufacturer);
        return manufacturer;
    }

    @Override
    @Transactional
    public Manufacturer update(Long id, Manufacturer manufacturer) {
        Manufacturer existing = findById(id);
        existing.name = manufacturer.name;
        existing.country = manufacturer.country;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}