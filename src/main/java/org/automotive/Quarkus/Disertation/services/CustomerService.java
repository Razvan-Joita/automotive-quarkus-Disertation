package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    Customer create(Customer customer);

    Customer update(Long id, Customer customer);

    void delete(Long id);
}