package com.Kunal.Chauhan.EmployeeApp.dao;

import com.Kunal.Chauhan.EmployeeApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // No need to write to any code
}
