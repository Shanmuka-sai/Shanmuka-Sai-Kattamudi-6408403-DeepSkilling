package com.cognizant.orm_compare;

import com.cognizant.orm_compare.model.Employee;
import com.cognizant.orm_compare.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmCompareApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmCompareApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // This will run after Spring Boot starts
        Employee e = new Employee();
        e.setName("SpringBoot");
        e.setDepartment("IT");
        employeeService.addEmployee(e);

        System.out.println("Employee added via Spring Data JPA");
    }
}
