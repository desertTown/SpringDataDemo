package com.jluzh.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataSourceTest {
    private ApplicationContext ctx;
    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    @Test
    public void testDataSource() {
        System.out.println("getDataSource");
        DataSource ds = (DataSource)ctx.getBean("dataSource");
        Assert.assertNotNull(ds);
    }

    @Test
    public void testJdbcTemplate() {
        System.out.println("getJdbcTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
    }
}
