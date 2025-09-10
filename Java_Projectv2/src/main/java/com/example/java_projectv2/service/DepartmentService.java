package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.dto.department.DepartmentCreateDto;
import com.example.java_projectv2.dto.department.DepartmentDeleteDto;
import com.example.java_projectv2.dto.department.DepartmentGetDto;
import com.example.java_projectv2.dto.department.DepartmentUpdateDto;
import java.util.List;

public interface DepartmentService
{
    List<DepartmentGetDto> getAllDepartments();
    DepartmentGetDto getDepartmentById(Long id);
    DepartmentCreateDto createDepartment(DepartmentCreateDto departmentCreateDto);
    DepartmentUpdateDto updateDepartment(DepartmentUpdateDto departmentUpdateDto);

    void deleteDepartmentById(DepartmentDeleteDto departmentDeleteDto);


    List<EmployeeDto> findAllEmployeesByDepartmentId(Long id);
}
