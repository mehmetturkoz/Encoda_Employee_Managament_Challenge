package com.enoca.employee_management.model.repository;

import com.enoca.employee_management.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllBySalaryGreaterThan(Double salary);
}
