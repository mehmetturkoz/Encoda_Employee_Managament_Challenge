package com.enoca.employee_management.model.repository;

import com.enoca.employee_management.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
