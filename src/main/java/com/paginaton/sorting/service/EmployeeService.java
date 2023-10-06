package com.paginaton.sorting.service;

import com.paginaton.sorting.dto.Employee;
import com.paginaton.sorting.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void loadEmployees(){

        List<Employee> employeeList= IntStream.rangeClosed(1,150)
                .mapToObj(i->new Employee(i,"Jagan"+i,new Random().nextDouble(100)))
                .collect(Collectors.toList());
        Random rand = new Random();
        //java 7
 /*       List<Employee> employeeList=new ArrayList<>();

        for(int i=1;i<=100;i++){
            Employee emp=new Employee();
            emp.setId(i);
            emp.setEmployeeName("Jagan"+i);
            emp.setSalary(rand.nextDouble());
            employeeList.add(emp);
        }*/
        employeeRepository.saveAll(employeeList);

    }

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }

    public List<Employee> employessWithSorting(String name){
       return  employeeRepository.findAll(Sort.by(name).descending());

    }

    public Page<Employee> findEmployeeWithPagination(int offSet, int pageNumber) {

        return employeeRepository.findAll(PageRequest.of(offSet,pageNumber));


    }

    public Page<Employee> findEmployeeWithPaginationSort(int offSet, int pageNumber, String name) {
        return employeeRepository.findAll(PageRequest.of(offSet,pageNumber).withSort(Sort.by(name).descending()));
    }
}
