package com.acnovate.Employee.web;

import com.acnovate.Employee.entity.Employee;
import com.acnovate.Employee.entity.Result;
import com.acnovate.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Employee")

public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>( employeeService.getEmployees(),HttpStatus.OK);
    }
    @GetMapping("/find/{name}")
    public ResponseEntity<Result> getEmployeeSupervisors(@PathVariable String name) {
        return new ResponseEntity<>( employeeService.getEmployeeSupervisors(name),HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<HttpStatus> saveEmployee(@RequestBody Map<String, String> emp_Details) {  // iteratively saving the values
        for (Map.Entry<String, String> itr : emp_Details.entrySet()) {
            employeeService.saveEmployee(itr.getKey(),itr.getValue());
        }
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    //DELETE  : Not required
    //PUT : Not Required

}

