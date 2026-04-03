package org.automotive.Quarkus.Disertation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {

    @Column(name = "amount")
    public Double amount;

    @JsonIgnoreProperties({"parts", "vehicle", "mechanic"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_record_id", unique = true)
    public ServiceRecord serviceRecord;
}