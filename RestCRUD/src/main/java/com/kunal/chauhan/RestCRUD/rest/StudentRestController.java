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

    @ExceptionHandler // handles StudentNotFoundException
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundExecption e){

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());

        error.setMessage(e.getMessage());

        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllTypesOfStudentException(Exception e){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
