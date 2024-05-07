package com.fieldMapping.fieldMapping.service;

import com.fieldMapping.fieldMapping.entity.Employee;
import com.fieldMapping.fieldMapping.entity.User;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    public Employee mapUserToEmployee(User user) {
        // Create a new Employee object
        Employee employee = new Employee();
        // Map user attributes to employee fields
        employee.setName(user.getFirstname()); // Assuming first name maps to name in Employee
        employee.setEmployee_email(user.getUser_email()); // Assuming user's email maps to employee_email
        employee.setMobile_no(user.getContact_No()); // Assuming contact_no maps to mobile_no

        // If description is available in User entity, set it to employee's summary
        if (user.getDescription() != null) {
            employee.setSummary(user.getDescription()); // Assuming description maps to summary
        }

        // Save the employee or perform any additional logic
        // Return the mapped employee
        return employee;
    }
}
