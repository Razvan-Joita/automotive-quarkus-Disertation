package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Part;
import org.automotive.Quarkus.Disertation.repositories.PartRepository;
import org.automotive.Quarkus.Disertation.services.PartService;

import java.util.List;

@ApplicationScoped
public class PartServiceImpl implements PartService {

    @Inject
    PartRepository repository;

    @Override
    public List<Part> findAll() {
        return repository.listAll();
    }

    @Override
    public Part findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Part not found with id " + id));
    }

    @Override
    @Transactional
    public Part create(Part part) {
        repository.persist(part);
        return part;
    }

    @Override
    @Transactional
    public Part update(Long id, Part part) {
        Part existing = findById(id);
        existing.name = part.name;
        existing.partNumber = part.partNumber;
        existing.description = part.description;
        existing.price = part.price;
        existing.quantity = part.quantity;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}