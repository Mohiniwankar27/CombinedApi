package com.fieldMapping.fieldMapping.service;

import com.fieldMapping.fieldMapping.entity.Employee;
import com.fieldMapping.fieldMapping.entity.User;
import com.fieldMapping.fieldMapping.repository.EmployeeRepository;
import com.fieldMapping.fieldMapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository; // Inject UserRepository

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    // Method to get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Method to save an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Method to get user details by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Add other methods as needed
}
