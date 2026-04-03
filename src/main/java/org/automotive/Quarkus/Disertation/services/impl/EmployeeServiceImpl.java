package org.automotive.Quarkus.Disertation.services.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.automotive.Quarkus.Disertation.exceptions.ResourceNotFoundException;
import org.automotive.Quarkus.Disertation.models.Employee;
import org.automotive.Quarkus.Disertation.repositories.EmployeeRepository;
import org.automotive.Quarkus.Disertation.services.EmployeeService;

import java.util.List;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.listAll();
    }

    @Override
    public Employee findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        repository.persist(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee update(Long id, Employee employee) {
        Employee existing = findById(id);
        existing.name = employee.name;
        existing.role = employee.role;
        existing.email = employee.email;
        existing.phone = employee.phone;
        existing.dealership = employee.dealership;
        return existing;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}