package com.cognizant.orm_compare.service;

import com.cognizant.orm_compare.model.Employee;
import com.cognizant.orm_compare.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public void addEmployee(Employee e) {
        repository.save(e);
    }
}
