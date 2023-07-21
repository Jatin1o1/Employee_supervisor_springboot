package com.acnovate.Employee.repository;

import com.acnovate.Employee.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    Employee findByName(String name);
    Optional<Employee> findBySupervisor(Long supervisor);
}
