package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Appointment;
import org.automotive.Quarkus.Disertation.repositories.AppointmentRepository;
import org.automotive.Quarkus.Disertation.services.AppointmentService;

import java.util.List;

@ApplicationScoped
public class AppointmentServiceImpl implements AppointmentService {

    @Inject
    AppointmentRepository repository;

    @Override
    public List<Appointment> findAll() {
        return repository.listAll();
    }

    @Override
    public Appointment findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
    }

    @Override
    @Transactional
    public Appointment create(Appointment appointment) {
        repository.persist(appointment);
        return appointment;
    }

    @Override
    @Transactional
    public Appointment update(Long id, Appointment appointment) {
        Appointment existing = findById(id);
        existing.date = appointment.date;
        existing.vehicle = appointment.vehicle;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}