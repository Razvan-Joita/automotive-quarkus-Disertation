package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.ServiceRecord;

import java.util.List;

public interface ServiceRecordService {
    List<ServiceRecord> findAll();

    ServiceRecord findById(Long id);

    ServiceRecord create(ServiceRecord serviceRecord);

    ServiceRecord update(Long id, ServiceRecord serviceRecord);

    void delete(Long id);
}