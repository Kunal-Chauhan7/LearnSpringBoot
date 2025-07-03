package com.kunal.chauhan.CRUDdemo.dao;

import com.kunal.chauhan.CRUDdemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAoImpl implements StudentDAO {


    // define entity manager which will deal with the jpa
    private EntityManager entityManager;

    // injecting bean and it is a constructor injection
    @Autowired
    public StudentDAoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent); // store the data using this pers ist method
    }

    @Override
    // if you only read then @transitional is not mandatory
    public Student findById(Integer id){
        return entityManager.find(Student.class,id); // return object
    }

}
