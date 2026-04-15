package com.example.java_projectv2.service.department;

import com.example.java_projectv2.dto.department.*;
import com.example.java_projectv2.dto.employee.EmployeeDto;

import java.util.List;

public interface DepartmentService
{
    List<DepartmentGetDto> getAllDepartments();
    DepartmentGetDto getDepartmentById(Long id);
    DepartmentCreateDto createDepartment(DepartmentCreateDto departmentCreateDto);
    DepartmentUpdateDto updateDepartment(DepartmentUpdateDto departmentUpdateDto);
    void deleteDepartmentById(DepartmentDeleteDto departmentDeleteDto);


    List<DepartmentGetFilterDto> getDepartmentsByfilter(DepartmentGetFilterDto dto);

    List<EmployeeDto> findAllEmployeesByDepartmentId(Long id);
}
