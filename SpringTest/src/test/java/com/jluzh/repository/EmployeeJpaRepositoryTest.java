package com.jluzh.repository;

import com.jluzh.domain.Employee;
import com.jluzh.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class EmployeeJpaRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;
    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testFind() {
        Employee employee = employeeJpaRepository.findOne(10);
        System.out.println("employee:"+employee);
    }

}