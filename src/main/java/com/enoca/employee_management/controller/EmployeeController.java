package com.enoca.employee_management.controller;

import com.enoca.employee_management.model.entity.Company;
import com.enoca.employee_management.model.entity.Employee;
import com.enoca.employee_management.model.service.AbstractCompanyService;
import com.enoca.employee_management.model.service.AbstractEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/employee")
@RestController
public class EmployeeController {

    @Autowired
    private AbstractEmployeeService employeeService;

    @Autowired
    private AbstractCompanyService companyService;

    @DeleteMapping("delete/{employeeID}")
    public ResponseEntity delete(@PathVariable Long employeeID){
        employeeService.deleteById(employeeID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        employee.setHireDate(new Date());
        Employee emp = employeeService.save(employee);

        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping("update/{employeeID}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeID,@RequestBody Employee employee){
        Employee employeeNew = employeeService.update(employee);
        return new ResponseEntity<>(employeeNew,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employeeList = employeeService.getAll();

        return ResponseEntity.ok(employeeList);
    }
}
