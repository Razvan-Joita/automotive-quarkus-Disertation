package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Warranty;

import java.util.List;

public interface WarrantyService {
    List<Warranty> findAll();

    Warranty findById(Long id);

    Warranty create(Warranty warranty);

    Warranty update(Long id, Warranty warranty);

    void delete(Long id);
}