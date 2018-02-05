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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;

public class EmployeeJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;
    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    /**
     * 1.分页
     * 2.排序
     * 3.查询条件 age > 50
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0, 5,sort);
        /**
         *  root:就是我們要查詢的類型（Employee）
         *  query：添加查詢的條件
         *  criteriaBuilder： 构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Path path = root.get("age");
                return criteriaBuilder.gt(path,50);
            }
        };
        Page<Employee> employees = employeeJpaSpecificationExecutorRepository.findAll(specification, pageable);
        System.out.println("查询页数:"+employees.getTotalPages());
        System.out.println("查询总记录数:"+employees.getTotalElements());

    }
}