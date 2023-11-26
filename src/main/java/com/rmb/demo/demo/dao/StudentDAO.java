package com.rmb.demo.demo.dao;

import com.rmb.demo.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);

    ArrayList<Student> studentList();

    List<Student> findBylastName(String name);

    void update(Student student);

    void delete(int id);

    int deleteAll();

}
