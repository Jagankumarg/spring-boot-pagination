package com.paginaton.sorting.service;

import com.paginaton.sorting.dto.Employee;
import com.paginaton.sorting.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void loadEmployees(){
        Random rand = new Random();
        List<Employee> employeeList=new ArrayList<>();

        for(int i=1;i<=100;i++){
            Employee emp=new Employee();
            emp.setId(i);
            emp.setEmployeeName("Jagan"+i);
            emp.setSalary(rand.nextDouble());
            employeeList.add(emp);
        }
        employeeRepository.saveAll(employeeList);

    }

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }
}
