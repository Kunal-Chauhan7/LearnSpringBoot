package com.Kunal.Chauhan.EmployeeApp.dao;

import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


// now it will be like http://localhost:8081/magic-api/members/2
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // No need to write to any code
}
