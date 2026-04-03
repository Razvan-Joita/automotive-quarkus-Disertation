package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.AppointmentDTO;
import org.automotive.Quarkus.Disertation.models.Appointment;

@ApplicationScoped
public class AppointmentMapper {
    public AppointmentDTO toDto(Appointment entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.id = entity.id;
        dto.date = entity.date;
        dto.vehicleId = entity.vehicle != null ? entity.vehicle.id : null;
        return dto;
    }

    public Appointment toEntity(AppointmentDTO dto) {
        Appointment entity = new Appointment();
        entity.id = dto.id;
        entity.date = dto.date;
        return entity;
    }
}