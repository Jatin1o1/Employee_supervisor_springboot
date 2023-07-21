package com.acnovate.Employee.service;

import com.acnovate.Employee.entity.Employee;
import com.acnovate.Employee.entity.Result;
import com.acnovate.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
    }

    @Override
    public Result getEmployeeSupervisors(String name) {
        Employee emp = employeeRepository.findByName(name);
        Result result= new Result();
        result.name=name;
        if (emp!=null) {
            Employee sup = employeeRepository.findById(emp.getSupervisor()).orElse(null);
            result.supervisor = sup != null ? sup.getName() : " Supervisor doesn't Exists";

            Employee SUP_sup = employeeRepository.findById(sup.getSupervisor()).orElse(null);
            result.supervisorS_supervisor = sup != null && SUP_sup != null ? SUP_sup.getName() : "No supervisor's supervisor";



//            result.supervisorS_supervisor=sup_sup_name;

        }

        return result;
    }

    public void saveEmployee(String name, String sup_name){
        Employee sup;
        Long index=null ;

        if (sup_name != null) {
            sup = employeeRepository.findByName(sup_name);
            if (sup==null) {
                Employee e = new Employee();
                e.setName(sup_name);
                e.setSupervisor(null);
                employeeRepository.save(e);
            }
            index = employeeRepository.findByName(sup_name).getId();
        }
        Employee emp = employeeRepository.findByName(name);
        if (emp == null) {
            emp= new Employee();
        }
        emp.setName(name);
        emp.setSupervisor(index);
        employeeRepository.save(emp);
    }


    @Override
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
