package org.automotive.Quarkus.Disertation.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.models.Appointment;

@ApplicationScoped
public class AppointmentRepository implements PanacheRepository<Appointment> {
}