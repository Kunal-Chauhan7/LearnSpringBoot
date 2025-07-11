package com.Kunal.Chauhan.EmployeeApp.dao;

import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository // mark this as a repository This means the class is responsible for encapsulating data access logic,
// providing mechanisms for storage, retrieval, search, update,
// and deletion of objects, typically interacting with a database or other data sources.

public class EmployeeDAOImplJPA implements EmployeeDAO{

    // filed for the entity manager
    private EntityManager entityManager;


    // injecting the entity manager bean in this constructor this bean will be injected from the spring
    // boot by default automatically created by spring boot
    @Autowired
    EmployeeDAOImplJPA(EntityManager thEntityManager){
        this.entityManager = thEntityManager;
    }


    @Override
    public List<Employee> getAllEmployees() {

        // create a Query
        TypedQuery<Employee> thequery = entityManager.createQuery("FROM Employee",Employee.class); // this FROM Employee
        // this right here Employee is an entity or the class we have defined as entity

        // execute the query and fetch the data
        List<Employee> employees =  thequery.getResultList();

        // return the result of the query
        return  employees;
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee SaveEmployee(Employee theEmployee) {

        Employee newEmployee = entityManager.merge(theEmployee); // Add a new employee / save a new employee

        return newEmployee; // return the new employee that has been created
    }

    @Override
    public void deleteEmployee(int id) {


//        Employee theEmployee = entityManager.find(Employee.class,id); similar to the above-mentioned method so i wil call that one

        Employee theEmployee = getEmployee(id); // find the employee by using the id

        entityManager.remove(theEmployee); // Delete the employee that has been found


    }
}
