package com.kunal.chauhan.CRUDdemo.dao;

import com.kunal.chauhan.CRUDdemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent); // storing / saving the object / data
    Student findById(Integer id); // finding a student of a specific id
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void updateStudent (Student student);
    void deleteStudent(Integer id);
    void DeleteAllStudents();
}
