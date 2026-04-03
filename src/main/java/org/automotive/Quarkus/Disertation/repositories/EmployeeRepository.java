package org.automotive.Quarkus.Disertation.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.automotive.Quarkus.Disertation.models.Employee;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {
}