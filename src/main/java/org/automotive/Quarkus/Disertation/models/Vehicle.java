package org.automotive.Quarkus.Disertation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity {

    @NotBlank
    @Column(name = "vin", unique = true)
    public String vin;

    @NotBlank
    @Column(name = "license_plate", unique = true)
    public String licensePlate;

    @NotBlank
    @Column(name = "make")
    public String make;

    @NotBlank
    @Column(name = "model")
    public String model;

    @NotNull
    @Column(name = "year")
    public Integer year;

    @Column(name = "fuel_type")
    public String fuelType;

    @Column(name = "status")
    public String status;

    @JsonIgnoreProperties("vehicles")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    public Manufacturer manufacturer;
}