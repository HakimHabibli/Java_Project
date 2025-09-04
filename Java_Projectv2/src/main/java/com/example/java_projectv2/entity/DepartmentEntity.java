package com.example.java_projectv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "department")
public class DepartmentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String DepartmentName;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EmployeeEntity> employees;
}
