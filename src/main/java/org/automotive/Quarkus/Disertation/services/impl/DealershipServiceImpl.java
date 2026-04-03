package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Dealership;
import org.automotive.Quarkus.Disertation.repositories.DealershipRepository;
import org.automotive.Quarkus.Disertation.services.DealershipService;

import java.util.List;

@ApplicationScoped
public class DealershipServiceImpl implements DealershipService {

    @Inject
    DealershipRepository repository;

    @Override
    public List<Dealership> findAll() {
        return repository.listAll();
    }

    @Override
    public Dealership findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership not found with id " + id));
    }

    @Override
    @Transactional
    public Dealership create(Dealership dealership) {
        repository.persist(dealership);
        return dealership;
    }

    @Override
    @Transactional
    public Dealership update(Long id, Dealership dealership) {
        Dealership existing = findById(id);
        existing.name = dealership.name;
        existing.location = dealership.location;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}