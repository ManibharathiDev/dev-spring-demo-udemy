package com.rmb.demo.demo.dao;

import com.rmb.demo.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAPImpl implements StudentDAO{

    // Define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection


    @Autowired
    public StudentDAPImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return this.entityManager.find(Student.class,id);
    }

    @Override
    public ArrayList<Student> studentList() {
//        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student",Student.class);
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by firstName",Student.class);
        return (ArrayList<Student>) typedQuery.getResultList();
    }

    @Override
    public List<Student> findBylastName(String name) {
        //Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student where lastName=:theData",Student.class);

        // Set Query Parameters
        theQuery.setParameter("theData",name);

        // Return Query Results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {

        Student student = entityManager.find(Student.class,id);
        this.entityManager.remove(student);

        //this.entityManager.remove(this.entityManager.getReference(Student.class,id));
        //this.entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = this.entityManager
                .createQuery("DELETE FROM Student")
                .executeUpdate();
        return 0;
    }
}
