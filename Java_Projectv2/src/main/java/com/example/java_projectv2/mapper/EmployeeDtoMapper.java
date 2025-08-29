package com.example.java_projectv2.mapper;

import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmployeeDtoMapper implements Function<EmployeeEntity, EmployeeDto>
{
    @Override
    public EmployeeDto apply(EmployeeEntity employee) {
        return new EmployeeDto
                (
                        employee.getId(),
                        employee.getName(),
                        employee.getPosition(),
                        employee.getSalary()
                );
    }
    public EmployeeEntity toEntity(EmployeeDto dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(dto.name());
        entity.setPosition(dto.position());
        entity.setSalary(dto.salary());
        return entity;
    }
}
