package com.Kunal.Chauhan.EmployeeApp.service;

import com.Kunal.Chauhan.EmployeeApp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeByUd(int id);

    Employee SaveEmployee(Employee theEmployee);

    void deleteEmployee(int id);
}
