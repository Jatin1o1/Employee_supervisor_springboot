package com.acnovate.Employee.service;

import com.acnovate.Employee.entity.Employee;
import com.acnovate.Employee.entity.Result;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Long id);

    Result getEmployeeSupervisors(String name);

    void saveEmployee(String name, String sup_name);
    List<Employee> getEmployees();

}
