package com.luv2code.springboot.thymleafEmployeeApp.controller;

import com.luv2code.springboot.thymleafEmployeeApp.entity.Employee;
import com.luv2code.springboot.thymleafEmployeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/create-employee")
    public String createNewEmployee(Model themodel){
        Employee employee = new Employee();
        themodel.addAttribute("employee",employee);
        return "create-new-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/employees-list";
    }

    @GetMapping("/update-employee")
    public String updateEmployee(@RequestParam("employeeId") int employeeId , Model theModel){

        Employee theEmployee = employeeService.findById(employeeId);

        theModel.addAttribute("employee",theEmployee);

        return "create-new-employee";
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId , Model theModel){

        employeeService.deleteById(employeeId);

        return "redirect:/employees/employees-list";
    }

}
