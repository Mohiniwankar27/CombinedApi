package com.fieldMapping.fieldMapping.controller;

import com.fieldMapping.fieldMapping.entity.Employee;
import com.fieldMapping.fieldMapping.entity.User;
import com.fieldMapping.fieldMapping.service.UserService;
import com.fieldMapping.fieldMapping.service.EmployeeService;
import com.fieldMapping.fieldMapping.service.MappingService; // Assuming you have a service for mapping user attributes to employee

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final EmployeeService employeeService;
    private final MappingService mappingService; // Inject MappingService

    @Autowired
    public UserController(UserService userService, EmployeeService employeeService, MappingService mappingService) {
        this.userService = userService;
        this.employeeService = employeeService;
        this.mappingService = mappingService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUserAndEmployee(@RequestBody User user) {
        // Save the User entity
        User savedUser = userService.saveUser(user);

        // Call the method to map user attributes to employee
        Employee employee = mappingService.mapUserToEmployee(savedUser);

        // Save the Employee entity
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // You can return any relevant data or simply a success message
        return ResponseEntity.status(HttpStatus.CREATED).body("User and Employee created successfully");
    }

    // Add other endpoints as needed
}

