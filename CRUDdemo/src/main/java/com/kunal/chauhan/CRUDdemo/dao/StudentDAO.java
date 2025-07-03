package com.kunal.chauhan.CRUDdemo.dao;

import com.kunal.chauhan.CRUDdemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent); // storing / saving the object / data
    Student findById(Integer id);
}
