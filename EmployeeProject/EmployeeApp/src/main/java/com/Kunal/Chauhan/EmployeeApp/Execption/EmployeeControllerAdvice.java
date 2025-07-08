package com.Kunal.Chauhan.EmployeeApp.Execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<EmployeeExecptionResponse> handleIdNotFoundException(EmployeeNotExecption e){
        EmployeeExecptionResponse response = new EmployeeExecptionResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimeStamo(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExecptionResponse> handleAllException(Exception e){
        EmployeeExecptionResponse response = new EmployeeExecptionResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimeStamo(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
