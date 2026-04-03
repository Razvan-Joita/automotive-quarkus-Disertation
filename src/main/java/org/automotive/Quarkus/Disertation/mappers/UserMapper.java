package org.automotive.Quarkus.Disertation.mappers;


import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.dtos.UserDTO;
import org.automotive.Quarkus.Disertation.models.User;

@ApplicationScoped
public class UserMapper {
    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.id = entity.id;
        dto.username = entity.username;
        dto.role = entity.role;
        return dto;
    }
}