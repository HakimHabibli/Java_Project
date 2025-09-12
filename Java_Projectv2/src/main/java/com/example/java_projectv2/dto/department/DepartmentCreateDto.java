package com.example.java_projectv2.dto.department;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentCreateDto
{

    private String departmentName;
}
