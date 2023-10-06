package com.paginaton.sorting.controller;

import com.paginaton.sorting.dto.Employee;
import com.paginaton.sorting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("pagination/employees")
    public List<Employee> getEmployees() {

        return employeeService.getEmployees();
    }
}
