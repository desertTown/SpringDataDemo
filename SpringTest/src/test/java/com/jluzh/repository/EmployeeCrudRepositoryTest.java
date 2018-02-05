package com.jluzh.repository;

import com.jluzh.domain.Employee;
import com.jluzh.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCrudRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeCrudRepository employeeCrudRepository = null;
    private EmployeeService employeeServicel = null;
    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeCrudRepository = ctx.getBean(EmployeeCrudRepository.class);
        employeeServicel = ctx.getBean(EmployeeService.class);
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testSave() {
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = null;
        for (int i = 0; i< 10; i++) {
            employee = new Employee();
            employee.setAge(100-i);
            employee.setName("test" + i);
            employees.add(employee);
        }
        employeeServicel.save(employees);
    }


}
