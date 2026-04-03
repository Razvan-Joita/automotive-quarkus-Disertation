package org.automotive.Quarkus.Disertation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotBlank
    @Column(name = "username", unique = true)
    public String username;

    @NotBlank
    @Column(name = "password")
    public String password;

    @NotBlank
    @Column(name = "role")
    public String role;
}