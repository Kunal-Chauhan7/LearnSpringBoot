package com.kunal.chauhan.CRUDdemo.dao;

import com.kunal.chauhan.CRUDdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
//                                         return the list as lastname in ascending order sorted by last name (A-Z)
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc",Student.class);
//        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        return  theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // creating the query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =:studentLastName",Student.class);

        // setting the parameter
        theQuery.setParameter("studentLastName", theLastName);

        // returning the result list
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student thestudent) {
        entityManager.merge(thestudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {

        // find the student with id to delete
        Student theStudent = entityManager.find(Student.class , id);

        // delete the student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public void DeleteAllStudents() {
        int numberOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println(numberOfRowsDeleted + " Number of Rows Deleted");
    }

}
