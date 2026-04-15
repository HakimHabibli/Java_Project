package com.example.java_projectv2.dto.department;

import com.example.java_projectv2.dto.employee.GetEmployeeSpecificationDto;
import jakarta.annotation.Nullable;
import lombok.Getter;

import java.util.List;


@Getter
public class DepartmentGetFilterDto
{
    @Nullable
    private String departmentName;

    @Nullable
    private GetEmployeeSpecificationDto employees;
}
