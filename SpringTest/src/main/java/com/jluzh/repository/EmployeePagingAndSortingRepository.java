package com.jluzh.repository;

import com.jluzh.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {
}
