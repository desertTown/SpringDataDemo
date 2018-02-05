package com.jluzh.service;

import com.jluzh.domain.Employee;
import com.jluzh.repository.EmployeeCrudRepository;
import com.jluzh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void updateAgeAccordingId(Integer id, Integer age) {
        employeeRepository.updateAgeAccordingId(id, age);
    }

    @Transactional
    public void save(List<Employee> employeeList){
        employeeCrudRepository.save(employeeList);
    }
}
