package com.luv2code.springboot.thymleafEmployeeApp.controller;

import com.luv2code.springboot.thymleafEmployeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees") // base url
public class EmployeeController {

//    making the object for the employee service so that we can use the methods
    private EmployeeService employeeService;

    @Autowired // injecting the EmployeeService
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

//    adding mapping to getting the list of the employees
    @GetMapping("/employees-list")
    public String getAllTheEmployyes(Model theModel){
        theModel.addAttribute("employeeList",employeeService.findAll());
        return "list-employees";
    }

}
