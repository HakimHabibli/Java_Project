package com.example.java_projectv2.mapper;

import com.example.java_projectv2.dto.department.*;
import com.example.java_projectv2.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface DepartmentMapper
{
    @Mapping(source = "id", target = "id")
    @Mapping(source = "departmentName", target = "departmentName")
    DepartmentGetDto toGetDepartmentDto(DepartmentEntity department);

    List<DepartmentGetDto> toGetDepartmentDtoList(List<DepartmentEntity> departments);
    DepartmentEntity toDepartmentCreateEntity(DepartmentCreateDto createDto);
    DepartmentCreateDto toDepartmentCreateDto(DepartmentEntity department);
    DepartmentEntity toDepartmentUpdateEntity(DepartmentUpdateDto updateDto);
    DepartmentUpdateDto toDepartmentUpdateDto(DepartmentEntity department);

    DepartmentWithEmployeesDto toDepartmentWithEmployeesDto(DepartmentEntity department);
//    EmployeeDto toEmployeeDto(EmployeeEntity employee);
//    List<EmployeeDto> toEmployeeDtoList(List<EmployeeEntity> employees);
}