package com.jluzh.dao;

import com.jluzh.dao.StudentDao;
import com.jluzh.dao.StudentDaoImpl;
import com.jluzh.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentDaoSpringJdbcImplTest {
    private ApplicationContext ctx;
    private StudentDao studentDao;
    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao)ctx.getBean("studentDao");
    }
    @After
    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }
    @Test
    public void testQuery() throws Exception {
        List<Student> students = studentDao.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " , name:" + student.getName()
                    + ", age:" + student.getAge());
        }
    }

    @Test
    public void testSave() throws Exception {
        Student student = new Student();
        student.setName("test");
        student.setAge(30);
        studentDao.save(student);
    }

}