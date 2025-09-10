package com.example.java_projectv2.repository;

import com.example.java_projectv2.dto.employee.EmployeeDto;

import java.util.List;

public interface CustomDepartmentRepository
{
    public List<EmployeeDto> findAllEmployeesByDeparmentId(Long id);

}
