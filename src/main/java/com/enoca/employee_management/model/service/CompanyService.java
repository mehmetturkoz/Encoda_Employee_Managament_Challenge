package com.enoca.employee_management.model.service;

import com.enoca.employee_management.model.entity.Company;
import com.enoca.employee_management.model.entity.Employee;
import com.enoca.employee_management.utility.ExceptionMessageType;
import com.enoca.employee_management.utility.Util;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CompanyService extends AbstractCompanyService {
    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findByID(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
    }

    @Override
    public Company save(Company company) {
        try {
            return companyRepository.save(company);
        } catch (IllegalArgumentException e) {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            companyRepository.deleteById(id);
        }catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
        }
    }

    @Override
    public Company update(Company company) {
        try {
            Company companyFound = companyRepository.getById(company.getCompanyID());

            companyFound.setCompanyName(company.getCompanyName());
            companyFound.setCompanyPhone(company.getCompanyPhone());
            companyFound.setAddress(company.getAddress());

            return companyRepository.save(companyFound);
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
