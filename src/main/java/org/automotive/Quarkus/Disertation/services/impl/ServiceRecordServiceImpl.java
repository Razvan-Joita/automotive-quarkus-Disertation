package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.ServiceRecord;
import org.automotive.Quarkus.Disertation.repositories.ServiceRecordRepository;
import org.automotive.Quarkus.Disertation.services.ServiceRecordService;

import java.util.List;

@ApplicationScoped
public class ServiceRecordServiceImpl implements ServiceRecordService {

    @Inject
    ServiceRecordRepository repository;

    @Override
    public List<ServiceRecord> findAll() {
        return repository.listAll();
    }

    @Override
    public ServiceRecord findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service record not found with id " + id));
    }

    @Override
    @Transactional
    public ServiceRecord create(ServiceRecord serviceRecord) {
        repository.persist(serviceRecord);
        return serviceRecord;
    }

    @Override
    @Transactional
    public ServiceRecord update(Long id, ServiceRecord serviceRecord) {
        ServiceRecord existing = findById(id);
        existing.description = serviceRecord.description;
        existing.date = serviceRecord.date;
        existing.vehicle = serviceRecord.vehicle;
        existing.mechanic = serviceRecord.mechanic;
        existing.parts = serviceRecord.parts;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}