package org.automotive.Quarkus.Disertation.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.DealershipDTO;
import org.automotive.Quarkus.Disertation.models.Dealership;

@ApplicationScoped
public class DealershipMapper {
    public DealershipDTO todto(Dealership entity){
        DealershipDTO dto = new DealershipDTO();
        dto.id = entity.id;
        dto.name = entity.name;
        dto.location = entity.location;
        return dto;
    }
    public Dealership toEntity(DealershipDTO dto){
        Dealership entity = new Dealership();
        entity.id = dto.id;
        entity.name = dto.name;
        entity.location = dto.location;
        return entity;
    }


}
