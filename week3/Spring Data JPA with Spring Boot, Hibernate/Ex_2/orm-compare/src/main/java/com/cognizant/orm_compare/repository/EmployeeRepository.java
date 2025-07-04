package com.cognizant.orm_compare.repository;

import com.cognizant.orm_compare.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
