package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.EmployeeDTO;
import org.automotive.Quarkus.Disertation.models.Employee;

@ApplicationScoped
public class EmployeeMapper {
    public EmployeeDTO toDto(Employee entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.id = entity.id;
        dto.name = entity.name;
        dto.role = entity.role;
        dto.email = entity.email;
        dto.phone = entity.phone;
        dto.dealershipId = entity.dealership != null ? entity.dealership.id : null;
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        Employee entity = new Employee();
        entity.id = dto.id;
        entity.name = dto.name;
        entity.role = dto.role;
        entity.email = dto.email;
        entity.phone = dto.phone;
        return entity;
    }
}