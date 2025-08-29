package com.example.java_projectv2.dto;


import jakarta.validation.constraints.*;

public record EmployeeDto(


        Integer id,

        @NotBlank(message = "Name cannot be blank")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @NotBlank(message = "Position cannot be blank")
        @Size(min = 2, max = 100, message = "Position must be between 2 and 100 characters")
        String position,

        @Min(value = 0, message = "Salary must be positive")
        double salary
) { }