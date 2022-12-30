package com.enoca.employee_management.model.service;

import com.enoca.employee_management.model.entity.Company;
import com.enoca.employee_management.model.entity.Employee;
import com.enoca.employee_management.utility.ExceptionMessageType;
import com.enoca.employee_management.utility.Util;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService extends AbstractEmployeeService{
    @Override
    protected List<Employee> findAllBySalaryGreaterThan(Double salary) {
        return employeeRepository.findAllBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByID(Long employeeId) {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
    }

    @Override
    public Employee save(Employee employee) {
        try {
            employee.setCompany(companyRepository.save(employee.getCompany()));
            return employeeRepository.save(employee);
        } catch (IllegalArgumentException e) {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            employeeRepository.deleteById(id);
        }catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
        }
    }

    @Override
    public Employee update(Employee employee) {
        try {
            Employee employeeFound = employeeRepository.getById(employee.getEmployeeID());

            employeeFound.setFirstName(employee.getFirstName());
            employeeFound.setLastName(employee.getLastName());
            employeeFound.setSalary(employee.getSalary());
            employeeFound.setPhone(employee.getPhone());
            employeeFound.setEmail(employee.getEmail());
            employeeFound.setCompany(employee.getCompany());

            return employeeRepository.save(employeeFound);
        }catch (EntityNotFoundException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }
}
