package com.enoca.employee_management.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "EMPLOYEES_SEQUENCE", sequenceName = "EMP_SEQ",initialValue = 1,allocationSize = 1)
@Table(name = "EMPLOYEES")
@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_SEQUENCE")
    @Column(name = "EMPLOYEE_ID",nullable = false)
    @Id
    private Long employeeID;

    @Column(name = "FIRST_NAME",nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;

    @Column(name = "PHONE",nullable = false)
    private Long phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SALARY",nullable = false)
    private Double salary;

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
}
