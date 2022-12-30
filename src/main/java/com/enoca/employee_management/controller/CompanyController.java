package com.enoca.employee_management.controller;

import com.enoca.employee_management.model.entity.Company;
import com.enoca.employee_management.model.entity.Employee;
import com.enoca.employee_management.model.service.AbstractCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/company")
@RestController
public class CompanyController {

    @Autowired
    private AbstractCompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        Company comp = companyService.save(company);
        return new ResponseEntity<>(comp, HttpStatus.OK);
    }

    @PutMapping("update/{companyID}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long companyID,@RequestBody Company company){
        Company companyNew = companyService.update(company);
        return new ResponseEntity<>(companyNew,HttpStatus.OK);
    }

    @DeleteMapping("delete/{companyID}")
    public ResponseEntity delete(@PathVariable Long companyID){
        companyService.deleteById(companyID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll(){
        List<Company> companyList = companyService.getAll();

        return ResponseEntity.ok(companyList);
    }
}
