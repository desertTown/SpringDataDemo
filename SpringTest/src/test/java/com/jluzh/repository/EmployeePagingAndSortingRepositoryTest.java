package com.jluzh.repository;

import com.jluzh.domain.Employee;
import com.jluzh.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.Assert.*;

public class EmployeePagingAndSortingRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;
    private EmployeeService employeeServicel = null;
    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
        employeeServicel = ctx.getBean(EmployeeService.class);
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testPage() {
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> employees = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("查询页数:"+employees.getTotalPages());
        System.out.println("查询总记录数:"+employees.getTotalElements());
    }

    @Test
    public void testPageAndSort() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0, 5,sort);
        Page<Employee> employees = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("查询页数:"+employees.getTotalPages());
        System.out.println("查询总记录数:"+employees.getTotalElements());
    }
}