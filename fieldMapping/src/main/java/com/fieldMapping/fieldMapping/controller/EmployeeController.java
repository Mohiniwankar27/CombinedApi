package com.fieldMapping.fieldMapping.controller;

import com.fieldMapping.fieldMapping.entity.Employee;
import com.fieldMapping.fieldMapping.entity.User;
import com.fieldMapping.fieldMapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    // Endpoint to create an Employee based on User data
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployeeFromUser(@RequestBody User user) {
        // Create an Employee object using User data
        Employee employee = new Employee();
        employee.setName(user.getFirstname() + " " + user.getLastname());
        employee.setMobile_no(user.getContact_No());
        employee.setEmployee_email(user.getUser_email());
        employee.setSummary(user.getDescription());

        // Save the Employee entity using the created Employee object
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // Return the saved Employee entity in the response with a 201 Created status
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    // Add other endpoints as needed
}
