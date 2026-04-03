package org.automotive.Quarkus.Disertation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @NotBlank
    @Column(name = "name")
    public String name;

    @Column(name = "role")
    public String role;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phone;

    @JsonIgnoreProperties({"employees"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealership_id")
    public Dealership dealership;
}