package org.automotive.Quarkus.Disertation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "dealership")
public class Dealership extends BaseEntity {

    @NotBlank
    @Column(name = "name")
    public String name;

    @Column(name = "location")
    public String location;
}