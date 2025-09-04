package com.example.java_projectv2.dto.department;

import com.example.java_projectv2.dto.EmployeeDto;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartmentWithEmployeesDto
        extends BaseDepartmentDto
{
    private String departmentName;
    private List<EmployeeDto> employees;
}

