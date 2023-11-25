package com.rmb.demo.demo.dao;

import com.rmb.demo.demo.entity.Student;

import java.util.ArrayList;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);

    ArrayList<Student> studentList();

    void update(Student student);

    void delete(int id);

}
