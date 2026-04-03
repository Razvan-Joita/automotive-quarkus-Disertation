package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAll();

    Manufacturer findById(Long id);

    Manufacturer create(Manufacturer manufacturer);

    Manufacturer update(Long id, Manufacturer manufacturer);

    void delete(Long id);
}