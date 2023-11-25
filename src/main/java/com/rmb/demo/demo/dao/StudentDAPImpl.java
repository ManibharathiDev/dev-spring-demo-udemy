package com.rmb.demo.demo.dao;

import com.rmb.demo.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
