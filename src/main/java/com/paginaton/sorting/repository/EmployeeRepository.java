package com.paginaton.sorting.repository;

import com.paginaton.sorting.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer> {
}
