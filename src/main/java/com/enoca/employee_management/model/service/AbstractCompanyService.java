package com.enoca.employee_management.model.service;

import com.enoca.employee_management.model.entity.Company;
import com.enoca.employee_management.model.repository.CompanyRepository;
import com.enoca.employee_management.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCompanyService implements EntityService<Company,Long> {

    @Autowired
    protected CompanyRepository companyRepository;

    @Autowired
    protected EmployeeRepository employeeRepository;
}
