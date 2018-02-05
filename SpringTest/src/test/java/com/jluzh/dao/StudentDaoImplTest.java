package com.jluzh.dao;

import com.jluzh.dao.StudentDao;
import com.jluzh.dao.StudentDaoImpl;
import com.jluzh.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
    @Test
    public void testQuery() throws Exception {
        StudentDao studentDAO = new StudentDaoImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " , name:" + student.getName()
                    + ", age:" + student.getAge());
        }
    }

    @Test
    public void testSave() throws Exception {
        StudentDao studentDAO = new StudentDaoImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(30);

        studentDAO.save(student);
    }

}