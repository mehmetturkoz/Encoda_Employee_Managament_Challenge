package com.enoca.employee_management.model.service;

import com.enoca.employee_management.model.entity.Employee;
import com.enoca.employee_management.model.repository.CompanyRepository;
import com.enoca.employee_management.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractEmployeeService implements EntityService<Employee,Long>{

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Autowired
    protected CompanyRepository companyRepository;

    protected abstract List<Employee> findAllBySalaryGreaterThan(Double salary);
}
