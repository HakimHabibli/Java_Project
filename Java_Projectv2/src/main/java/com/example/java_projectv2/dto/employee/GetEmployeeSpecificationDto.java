package com.example.java_projectv2.dto.employee;


import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetEmployeeSpecificationDto
{
    @Nullable
    String name ;
    @Nullable
    String position;
    @Nullable
    Double minSalary;
    @Nullable
    Double maxSalary;
    @Nullable
    String finCode;
}
