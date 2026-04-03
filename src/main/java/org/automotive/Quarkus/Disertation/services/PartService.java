package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();

    Part findById(Long id);

    Part create(Part part);

    Part update(Long id, Part part);

    void delete(Long id);
}