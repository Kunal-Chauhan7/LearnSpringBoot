package com.Kunal.Chauhan.EmployeeApp.restController;

import com.Kunal.Chauhan.EmployeeApp.Execption.EmployeeNotExecption;
import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import com.Kunal.Chauhan.EmployeeApp.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {
    private EmployeeService employeeService;

    private ObjectMapper objectMapper; // object Mapper

    @Autowired
    public EmployeeRestController(EmployeeService employeeService , ObjectMapper objectMapper){ // injecting the bean in this constructor

        this.objectMapper = objectMapper; // injecting the ObjectMapper bean

        this.employeeService = employeeService; // injecting the EmployeeService Bean
    }


    private Employee applyPatch (Employee tempEmployee, Map<String , Object> patchPayLoad){

        // convert the tempEmployee to the JSON object node
        ObjectNode tempPatchedEmployee = objectMapper.convertValue(tempEmployee , ObjectNode.class);

        // convert the map to the JSON object node
        ObjectNode patchWork = objectMapper.convertValue(patchPayLoad,ObjectNode.class);

        // Merge the patch with the tempEmployee
        tempPatchedEmployee.setAll(patchWork);

        // convert the JSON object node into the employee class object / Employee Entity
        return objectMapper.convertValue(tempPatchedEmployee,Employee.class);
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


    @PutMapping("/employees") // will completely replace the resource and we need to pass on the json whole
    // object with the id of the resource of that object we want to put and completely replace
    public Employee updateTheEmployee(@RequestBody Employee theEmployee){
        Employee employee = employeeService.SaveEmployee(theEmployee);
        return  employee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchTheEmployee(@PathVariable int employeeId , @RequestBody Map<String , Object> patchPayload){
        Employee tempEmployee = employeeService.getEmployeeByUd(employeeId);
        if(tempEmployee == null){
            throw new EmployeeNotExecption("The Employee with the Id " + employeeId + "Do not exist");
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("The Following Request is not allowed pass the employee Id in params");
        }

        // apply patch
        Employee updatedEmployee = applyPatch(tempEmployee,patchPayload);

        // return the updated employee
        Employee dbERmployee = employeeService.SaveEmployee(updatedEmployee);

        return dbERmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteTheEmployeeById(@PathVariable int employeeId){

        if(employeeService.getEmployeeByUd(employeeId) == null){
            throw new EmployeeNotExecption("The employee with id " + employeeId + "does not exist");
        }

        employeeService.deleteEmployee(employeeId);

        return "Employee With id " + employeeId + " was deleted ";
    }

}
