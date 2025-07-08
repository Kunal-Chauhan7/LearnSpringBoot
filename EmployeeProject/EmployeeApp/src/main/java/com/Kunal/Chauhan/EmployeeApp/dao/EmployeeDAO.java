package com.Kunal.Chauhan.EmployeeApp.dao;

import com.Kunal.Chauhan.EmployeeApp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    Employee SaveEmployee(Employee theEmployee);

    void deleteEmployee(int id);
}
