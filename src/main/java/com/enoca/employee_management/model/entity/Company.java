package com.enoca.employee_management.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "COMPANIES_SEQUENCE", sequenceName = "CMP_SEQ",initialValue = 1,allocationSize = 1)
@Table(name = "COMPANIES")
@Entity
public class Company {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_SEQUENCE")
    @Column(name = "COMPANY_ID",nullable = false)
    @Id
    private Long companyID;

    @Column(name = "COMPANY_NAME",nullable = false)
    private String companyName;

    @Column(name = "COMPANY_PHONE",nullable = false)
    private Long companyPhone;

    @Column(name = "ADDRESS")
    private String address;

}
