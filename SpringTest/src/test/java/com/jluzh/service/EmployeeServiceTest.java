package com.jluzh.service;

import com.jluzh.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class EmployeeServiceTest {
    private ApplicationContext ctx = null;
    private EmployeeService employeeService = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testUpdateAgeAccordingId() {
        employeeService.updateAgeAccordingId(2,19);
    }

}