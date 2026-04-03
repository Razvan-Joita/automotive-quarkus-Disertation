package org.automotive.Quarkus.Disertation.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.ServiceRecordDTO;
import org.automotive.Quarkus.Disertation.models.ServiceRecord;

import java.util.stream.Collectors;

@ApplicationScoped
public class ServiceRecordMapper {
    public ServiceRecordDTO toDto(ServiceRecord entity) {
        ServiceRecordDTO dto = new ServiceRecordDTO();
        dto.id = entity.id;
        dto.description = entity.description;
        dto.date = entity.date;
        dto.vehicleId = entity.vehicle != null ? entity.vehicle.id : null;
        dto.mechanicId = entity.mechanic != null ? entity.mechanic.id : null;
        dto.partIds = entity.parts != null
                ? entity.parts.stream().map(p -> p.id).collect(Collectors.toList())
                : null;
        return dto;
    }
}