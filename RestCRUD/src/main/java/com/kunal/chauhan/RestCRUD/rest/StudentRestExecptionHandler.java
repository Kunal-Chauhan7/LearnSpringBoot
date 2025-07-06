package com.kunal.chauhan.RestCRUD.rest;

import com.kunal.chauhan.RestCRUD.entity.StudentErrorResponse;
import com.kunal.chauhan.RestCRUD.entity.StudentNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Handles all of the exceptions that This app raises in one place all the exception goes here global exception handler
public class StudentRestExecptionHandler {
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
