package com.example.java_projectv2.mapper;

import com.example.java_projectv2.dto.department.*;
import com.example.java_projectv2.entity.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper
{
    DepartmentGetDto toGetDepartmentDto(DepartmentEntity department);
    DepartmentWithEmployeesDto toDepartmentWithEmployeesDto(DepartmentEntity department);
    List<DepartmentGetDto> toGetDepartmentDtoList(List<DepartmentEntity> departments);
    DepartmentEntity toDepartmentCreateEntity(DepartmentCreateDto createDto);
    DepartmentEntity toDepartmentUpdateEntity(DepartmentUpdateDto updateDto);
    DepartmentEntity toDepartmentDeleteEntity(DepartmentDeleteDto deleteDto);
//    EmployeeDto toEmployeeDto(EmployeeEntity employee);
//    List<EmployeeDto> toEmployeeDtoList(List<EmployeeEntity> employees);
}