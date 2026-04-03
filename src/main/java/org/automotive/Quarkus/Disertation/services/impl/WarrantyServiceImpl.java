package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Warranty;
import org.automotive.Quarkus.Disertation.repositories.WarrantyRepository;
import org.automotive.Quarkus.Disertation.services.WarrantyService;

import java.util.List;

@ApplicationScoped
public class WarrantyServiceImpl implements WarrantyService {

    @Inject
    WarrantyRepository repository;

    @Override
    public List<Warranty> findAll() {
        return repository.listAll();
    }

    @Override
    public Warranty findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found with id " + id));
    }

    @Override
    @Transactional
    public Warranty create(Warranty warranty) {
        repository.persist(warranty);
        return warranty;
    }

    @Override
    @Transactional
    public Warranty update(Long id, Warranty warranty) {
        Warranty existing = findById(id);
        existing.startDate = warranty.startDate;
        existing.endDate = warranty.endDate;
        existing.vehicle = warranty.vehicle;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}