package com.Kunal.Chauhan.EmployeeApp.service;

import com.Kunal.Chauhan.EmployeeApp.dao.EmployeeRepository;
import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // define the dao field
    private EmployeeRepository theEmployeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){ // inject the employeeDAO bean in this constructor injection
        this.theEmployeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return theEmployeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByUd(int id) {
        Optional<Employee> result = theEmployeeRepository.findById(id); // JPA use optional may or may not
        Employee employee = null;
        if(result.isPresent())
            employee = result.get();
        else
            throw new RuntimeException("Employee with that employee does not exist");
        return employee;
    }

    @Override
    public Employee SaveEmployee(Employee theEmployee) {
        return theEmployeeRepository.save(theEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        theEmployeeRepository.deleteById(id);
    }
}
