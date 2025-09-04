package com.example.java_projectv2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String position;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity  department;

}


