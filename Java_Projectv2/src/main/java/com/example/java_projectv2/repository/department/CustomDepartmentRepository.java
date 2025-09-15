package com.example.java_projectv2.repository.department;

import com.example.java_projectv2.dto.employee.EmployeeDto;

import java.util.List;

public interface CustomDepartmentRepository
{
    public List<EmployeeDto> findAllEmployeesByDepartmentId(Long id);

}
