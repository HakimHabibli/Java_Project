package com.example.java_projectv2.mapper;

import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public List<EmployeeDto> toEntityList(List<EmployeeEntity> employees)
    {
        return employees.stream()
                .map(this::apply).collect(Collectors.toList());
    }
    public EmployeeEntity toEntity(EmployeeDto dto)
    {
        EmployeeEntity entity = new EmployeeEntity();

        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setPosition(dto.position());
        entity.setSalary(dto.salary());
        return entity;
    }
}
