package com.Kunal.Chauhan.EmployeeApp.restController;

import com.Kunal.Chauhan.EmployeeApp.Execption.EmployeeNotExecption;
import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import com.Kunal.Chauhan.EmployeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){ // injecting the bean in this constructor
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployeeByUd(id);
        if(employee == null){
            throw new EmployeeNotExecption("The Employee is not Found " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        Employee employee = employeeService.SaveEmployee(theEmployee);
        return employee;
    }

}
