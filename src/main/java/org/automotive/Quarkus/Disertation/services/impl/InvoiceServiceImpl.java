package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Invoice;
import org.automotive.Quarkus.Disertation.repositories.InvoiceRepository;
import org.automotive.Quarkus.Disertation.services.InvoiceService;

import java.util.List;

@ApplicationScoped
public class InvoiceServiceImpl implements InvoiceService {

    @Inject
    InvoiceRepository repository;

    @Override
    public List<Invoice> findAll() {
        return repository.listAll();
    }

    @Override
    public Invoice findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id " + id));
    }

    @Override
    @Transactional
    public Invoice create(Invoice invoice) {
        repository.persist(invoice);
        return invoice;
    }

    @Override
    @Transactional
    public Invoice update(Long id, Invoice invoice) {
        Invoice existing = findById(id);
        existing.amount = invoice.amount;
        existing.serviceRecord = invoice.serviceRecord;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}