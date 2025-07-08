package com.Kunal.Chauhan.EmployeeApp.restController;

import com.Kunal.Chauhan.EmployeeApp.dao.EmployeeDAO;
import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {
    private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO){ // injecting the bean in this constructor
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }

}
