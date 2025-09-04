package com.example.java_projectv2.dto.department;

import com.example.java_projectv2.dto.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartmentGetDto
        extends BaseDepartmentDto
{
    private String departmentName;
}
