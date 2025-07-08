package com.Kunal.Chauhan.EmployeeApp.service;

import com.Kunal.Chauhan.EmployeeApp.dao.EmployeeDAO;
import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // define the dao field
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){ // inject the employeeDAO bean in this constructor injection
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeByUd(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional // since we are modifying the database we will add this transactional and service layer manages the
                  // the transitional
    public Employee SaveEmployee(Employee theEmployee) {
        return employeeDAO.SaveEmployee(theEmployee);
    }

    @Override
    @Transactional // since we are modifying the database we will add this transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
