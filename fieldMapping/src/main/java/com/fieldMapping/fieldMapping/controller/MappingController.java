package com.fieldMapping.fieldMapping.controller;

import com.fieldMapping.fieldMapping.entity.Employee;
import com.fieldMapping.fieldMapping.entity.User;
import com.fieldMapping.fieldMapping.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapping")
public class MappingController {

    @Autowired
    private MappingService mappingService;

    @PostMapping
    public ResponseEntity<Employee> mapUserToEmployee(@RequestBody User user) {
        Employee employee = mappingService.mapUserToEmployee(user);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
