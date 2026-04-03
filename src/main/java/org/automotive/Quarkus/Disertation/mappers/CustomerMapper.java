package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.CustomerDTO;
import org.automotive.Quarkus.Disertation.models.Customer;

@ApplicationScoped
public class CustomerMapper {
    public CustomerDTO toDto(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.id = entity.id;
        dto.firstName = entity.firstName;
        dto.lastName = entity.lastName;
        dto.email = entity.email;
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.id = dto.id;
        entity.firstName = dto.firstName;
        entity.lastName = dto.lastName;
        entity.email = dto.email;
        return entity;
    }
}