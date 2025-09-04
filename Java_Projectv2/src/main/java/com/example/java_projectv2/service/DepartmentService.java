package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.entity.DepartmentEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService
{
    List<DepartmentEntity> getAllDepartments();
    Optional<DepartmentEntity> getDepartmentById(long id);
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);
    DepartmentEntity updateDepartment(DepartmentEntity departmentEntity);
    void deleteDepartmentById(long id);


    List<EmployeeDto> findAllEmployeesByDepartmentId(long id);
}
