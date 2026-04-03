package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.ManufacturerDTO;
import org.automotive.Quarkus.Disertation.models.Manufacturer;

@ApplicationScoped
public class ManufacturerMapper {
    public ManufacturerDTO toDto(Manufacturer entity) {
        ManufacturerDTO dto = new ManufacturerDTO();
        dto.id = entity.id;
        dto.name = entity.name;
        dto.country = entity.country;
        return dto;
    }

    public Manufacturer toEntity(ManufacturerDTO dto) {
        Manufacturer entity = new Manufacturer();
        entity.id = dto.id;
        entity.name = dto.name;
        entity.country = dto.country;
        return entity;
    }
}