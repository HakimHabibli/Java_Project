package com.example.java_projectv2.dto.employee;

public record EmployeeCreateDto(
        int id,
        String name,
        String position,
        Double salary,
        Long departmentId
) {}
