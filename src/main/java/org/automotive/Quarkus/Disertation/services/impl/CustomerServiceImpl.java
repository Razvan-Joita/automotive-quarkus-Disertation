package org.automotive.Quarkus.Disertation.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Customer;
import org.automotive.Quarkus.Disertation.repositories.CustomerRepository;
import org.automotive.Quarkus.Disertation.services.CustomerService;

import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    @Inject
    CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.listAll();
    }

    @Override
    public Customer findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    @Override
    @Transactional
    public Customer create(Customer customer) {
        repository.persist(customer);
        return customer;
    }

    @Override
    @Transactional
    public Customer update(Long id, Customer customer) {
        Customer existing = findById(id);
        existing.firstName = customer.firstName;
        existing.lastName = customer.lastName;
        existing.email = customer.email;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}