package com.fieldMapping.fieldMapping.repository;

import com.fieldMapping.fieldMapping.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom query methods here if needed
}
