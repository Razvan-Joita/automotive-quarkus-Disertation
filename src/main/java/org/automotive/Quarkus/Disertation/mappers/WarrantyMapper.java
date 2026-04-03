package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.WarrantyDTO;
import org.automotive.Quarkus.Disertation.models.Warranty;

@ApplicationScoped
public class WarrantyMapper {
    public WarrantyDTO toDto(Warranty entity) {
        WarrantyDTO dto = new WarrantyDTO();
        dto.id = entity.id;
        dto.startDate = entity.startDate;
        dto.endDate = entity.endDate;
        dto.vehicleId = entity.vehicle != null ? entity.vehicle.id : null;
        return dto;
    }

    public Warranty toEntity(WarrantyDTO dto) {
        Warranty entity = new Warranty();
        entity.id = dto.id;
        entity.startDate = dto.startDate;
        entity.endDate = dto.endDate;
        return entity;
    }
}