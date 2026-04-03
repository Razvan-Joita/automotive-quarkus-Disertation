package org.automotive.Quarkus.Disertation.services;


import org.automotive.Quarkus.Disertation.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee create(Employee employee);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}