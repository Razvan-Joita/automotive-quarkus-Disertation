package org.automotive.Quarkus.Disertation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @NotBlank
    @Column(name = "first_name")
    public String firstName;

    @NotBlank
    @Column(name = "last_name")
    public String lastName;

    @Email
    @NotBlank
    @Column(name = "email", unique = true)
    public String email;
}