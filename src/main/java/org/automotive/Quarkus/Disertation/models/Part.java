package org.automotive.Quarkus.Disertation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "part")
public class Part extends BaseEntity {

    @NotBlank
    @Column(name = "name")
    public String name;

    @Column(name = "part_number")
    public String partNumber;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public BigDecimal price;

    @Column(name = "quantity")
    public Integer quantity;
}