package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.PartDTO;
import org.automotive.Quarkus.Disertation.models.Part;

@ApplicationScoped
public class PartMapper {
    public PartDTO toDto(Part entity) {
        PartDTO dto = new PartDTO();
        dto.id = entity.id;
        dto.name = entity.name;
        dto.partNumber = entity.partNumber;
        dto.description = entity.description;
        dto.price = entity.price;
        dto.quantity = entity.quantity;
        return dto;
    }

    public Part toEntity(PartDTO dto) {
        Part entity = new Part();
        entity.id = dto.id;
        entity.name = dto.name;
        entity.partNumber = dto.partNumber;
        entity.description = dto.description;
        entity.price = dto.price;
        entity.quantity = dto.quantity;
        return entity;
    }
}