package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();

    Appointment findById(Long id);

    Appointment create(Appointment appointment);

    Appointment update(Long id, Appointment appointment);

    void delete(Long id);
}