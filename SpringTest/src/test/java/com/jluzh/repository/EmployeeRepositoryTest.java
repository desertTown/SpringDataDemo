package com.jluzh.repository;

import com.jluzh.dao.StudentDao;
import com.jluzh.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testFindByName() {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id:"+employee.getId()+"\n"+"name:"+employee.getName());
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 21);
        for (Employee employee: employees) {
            System.out.println("id:"+employee.getId()+"\t"+"name:"+employee.getName()+"\t"+employee.getAge()+"\n");
        }

    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("1", 21);
        for (Employee employee: employees) {
            System.out.println("id:"+employee.getId()+"\t"+"name:"+employee.getName()+"\t"+employee.getAge()+"\n");
        }

    }

    @Test
    public void testFindByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);
        for (Employee employee: employees) {
            System.out.println("id:"+employee.getId()+"\t"+"name:"+employee.getName()+"\t"+employee.getAge()+"\n");
        }
    }

    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id:"+employee.getId()+"\t"+"name:"+employee.getName()+"\t"+employee.getAge()+"\n");
    }

    @Test
    public void testQueryParams1() {
        Employee employee = employeeRepository.queryParams1("test1",20);
        System.out.println("id:"+employee.getId()+"\t"+"name:"+employee.getName()+"\t"+employee.getAge()+"\n");
    }

    @Test
    public void testQueryParams2() {
        Employee employee = employeeRepository.queryParams2("test1",20);
        System.out.println("id:"+employee.getId()+"\t"+"name:"+employee.getName()+"\t"+employee.getAge()+"\n");
    }

    @Test
    public void testQueryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("test");
        for(Employee employee: employees) {
            System.out.println("id:"+employee.getId()+"\t"+"name:"+employee.getName()+"\t"+employee.getAge()+"\n");
        }
    }

    @Test
    public void testGetCount() {
        long count = employeeRepository.getCount();
        System.out.println("count:" +count);
    }


}
