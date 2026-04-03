package org.automotive.Quarkus.Disertation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_record")
public class ServiceRecord extends BaseEntity {

    @Column(name = "description")
    public String description;

    @NotNull
    @Column(name = "date")
    public LocalDate date;

    @JsonIgnoreProperties({"manufacturer", "serviceRecords"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    public Vehicle vehicle;

    @JsonIgnoreProperties({"dealership", "serviceRecords"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mechanic_id")
    public Employee mechanic;

    @JsonIgnoreProperties({"serviceRecords"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "service_record_parts",
            joinColumns = @JoinColumn(name = "service_record_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id")
    )
    public List<Part> parts = new ArrayList<>();
}