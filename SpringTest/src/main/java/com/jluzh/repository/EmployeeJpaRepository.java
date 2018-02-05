package com.jluzh.repository;

import com.jluzh.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
