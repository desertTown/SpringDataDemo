package com.jluzh.repository;

import com.jluzh.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer>{
}
