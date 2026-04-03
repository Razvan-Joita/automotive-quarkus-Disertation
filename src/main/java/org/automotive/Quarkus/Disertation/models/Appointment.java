package org.automotive.Quarkus.Disertation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    @NotNull
    @Column(name = "date")
    public LocalDate date;

    @JsonIgnoreProperties({"manufacturer", "appointments"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    public Vehicle vehicle;
}