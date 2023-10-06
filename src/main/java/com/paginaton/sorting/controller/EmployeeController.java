package com.paginaton.sorting.controller;

import com.paginaton.sorting.dto.APIResponse;
import com.paginaton.sorting.dto.Employee;
import com.paginaton.sorting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("sorting/{name}")
    public List<Employee> sortedEmployees(@PathVariable String name){
        return employeeService.employessWithSorting(name);
    }
    @GetMapping("pagination/{offSet}/{pageNumber}")
    public APIResponse<Page<Employee>> getEmployeeWithPagination(@PathVariable int offSet, @PathVariable int pageNumber){
        Page<Employee> empWithPagination=employeeService.findEmployeeWithPagination(offSet,pageNumber);
        return new APIResponse<>(empWithPagination.getSize(),empWithPagination);
    }
    @GetMapping("pagination/{offSet}/{pageNumber}/{name}")
    public APIResponse<Page<Employee>> getEmployeeWithPaginationSorting(@PathVariable int offSet, @PathVariable int pageNumber,@PathVariable String name){
        Page<Employee> empWithSortedPagination=employeeService.findEmployeeWithPaginationSort(offSet,pageNumber,name);
        return new APIResponse<>(empWithSortedPagination.getSize(),empWithSortedPagination);
    }
}
