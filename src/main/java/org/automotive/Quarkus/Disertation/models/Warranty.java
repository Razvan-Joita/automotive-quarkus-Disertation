package org.automotive.Quarkus.Disertation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "warranty")
public class Warranty extends BaseEntity {

    @NotNull
    @Column(name = "start_date")
    public LocalDate startDate;

    @NotNull
    @Column(name = "end_date")
    public LocalDate endDate;

    @JsonIgnoreProperties({"manufacturer", "warranties"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", unique = true)
    public Vehicle vehicle;
}