package com.kunal.chauhan.RestCRUD.rest;


import com.kunal.chauhan.RestCRUD.entity.Student;
import com.kunal.chauhan.RestCRUD.entity.StudentErrorResponse;
import com.kunal.chauhan.RestCRUD.entity.StudentNotFoundExecption;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // base request mapping
public class StudentRestController {

    List<Student> StudentList;
    @PostConstruct
    private void loacData(){
        StudentList = new ArrayList<>();
        StudentList.add(new Student("Kunal" , "Chauhan"));
        StudentList.add(new Student("Raju" , ""));
        StudentList.add(new Student("Babu Rao" , "Appte"));
        StudentList.add(new Student("Shyam" , ""));
    }


    // end point for "/students" - return a list of Students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return StudentList;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        if(studentId >= StudentList.size() || studentId < 0){
            throw new StudentNotFoundExecption("Student id is not found - "+studentId);
        }

        return StudentList.get(studentId);
    }

}
