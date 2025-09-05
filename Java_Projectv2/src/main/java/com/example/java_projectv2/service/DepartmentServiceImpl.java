package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.dto.department.DepartmentCreateDto;
import com.example.java_projectv2.dto.department.DepartmentDeleteDto;
import com.example.java_projectv2.dto.department.DepartmentGetDto;
import com.example.java_projectv2.dto.department.DepartmentUpdateDto;
import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.mapper.DepartmentMapper;
import com.example.java_projectv2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper)
    {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<DepartmentGetDto> getAllDepartments()
    {
        var entity =  departmentRepository.findAll();
        return departmentMapper.toGetDepartmentDtoList(entity);
    }
    @Override
    public DepartmentGetDto getDepartmentById(long id)
    {
        DepartmentEntity entity = departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found"));
        return departmentMapper.toGetDepartmentDto(entity);
    }

    @Override
    public DepartmentCreateDto createDepartment(DepartmentCreateDto departmentCreateDto) {
        var entity = departmentRepository.save(departmentMapper.toDepartmentCreateEntity(departmentCreateDto));

        return departmentMapper.toDepartmentCreateDto(entity);
    }

    @Override
    public DepartmentUpdateDto updateDepartment(DepartmentUpdateDto departmentUpdateDto) {
        var entity = departmentRepository.save(departmentMapper.toDepartmentUpdateEntity(departmentUpdateDto));
        return departmentMapper.toDepartmentUpdateDto(entity);
    }

    @Override
    public void deleteDepartmentById(DepartmentDeleteDto departmentDeleteDto)
    {
        departmentRepository.deleteById(departmentDeleteDto.getId());
    }

    @Override
    public List<EmployeeDto> findAllEmployeesByDepartmentId(long id) {
        return departmentRepository.findAllEmployeesByDeparmentId(id);
    }

}
