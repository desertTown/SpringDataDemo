package com.jluzh.dao;

import com.jluzh.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> query();
    void save(Student student);
}
