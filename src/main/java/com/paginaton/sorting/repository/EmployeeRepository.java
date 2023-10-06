package com.paginaton.sorting.repository;

import com.paginaton.sorting.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
