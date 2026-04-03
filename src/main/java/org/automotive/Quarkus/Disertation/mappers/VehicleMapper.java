package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.VehicleDTO;
import org.automotive.Quarkus.Disertation.models.Vehicle;

@ApplicationScoped
public class VehicleMapper {
    public VehicleDTO toDto(Vehicle entity) {
        VehicleDTO dto = new VehicleDTO();
        dto.id = entity.id;
        dto.vin = entity.vin;
        dto.licensePlate = entity.licensePlate;
        dto.make = entity.make;
        dto.model = entity.model;
        dto.year = entity.year;
        dto.fuelType = entity.fuelType;
        dto.status = entity.status;
        dto.manufacturerId = entity.manufacturer != null ? entity.manufacturer.id : null;
        return dto;
    }

    public Vehicle toEntity(VehicleDTO dto) {
        Vehicle entity = new Vehicle();
        entity.id = dto.id;
        entity.vin = dto.vin;
        entity.licensePlate = dto.licensePlate;
        entity.make = dto.make;
        entity.model = dto.model;
        entity.year = dto.year;
        entity.fuelType = dto.fuelType;
        entity.status = dto.status;
        return entity;
    }
}