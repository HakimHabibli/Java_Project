package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.dto.department.DepartmentCreateDto;
import com.example.java_projectv2.dto.department.DepartmentDeleteDto;
import com.example.java_projectv2.dto.department.DepartmentGetDto;
import com.example.java_projectv2.dto.department.DepartmentUpdateDto;
import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.mapper.DepartmentMapper;
import com.example.java_projectv2.repository.DepartmentRepository;
import com.example.java_projectv2.repository.EmployeeRepository;
import com.example.java_projectv2.rules.DepartmentRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final DepartmentRules departmentRules;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper, DepartmentRules departmentRules)
    {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.departmentRules = departmentRules;
    }

    @Override
    public List<DepartmentGetDto> getAllDepartments()
    {
        var entity =  departmentRepository.findAll();
        return departmentMapper.toGetDepartmentDtoList(entity);
    }

    @Override
    public DepartmentGetDto getDepartmentById(Long id)
    {
        DepartmentEntity entity = departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found"));
        return departmentMapper.toGetDepartmentDto(entity);
    }

    @Override
    public DepartmentCreateDto createDepartment(DepartmentCreateDto departmentCreateDto) {

        var entity = departmentMapper.toDepartmentCreateEntity(departmentCreateDto);

        //Business check
        departmentRules.checkNotNull(entity);
        departmentRules.checkIfUnique(entity);

        var saveEntity = departmentRepository.save(entity);
        return departmentMapper.toDepartmentCreateDto(saveEntity);
    }

    @Override
    public DepartmentUpdateDto updateDepartment(DepartmentUpdateDto departmentUpdateDto) {
        var entity = departmentMapper.toDepartmentUpdateEntity(departmentUpdateDto);

        departmentRules.checkNotNull(entity);
        departmentRules.checkIfUnique(entity);
        departmentRepository.save(entity);

        return departmentMapper.toDepartmentUpdateDto(entity);
    }

    @Override
    public void deleteDepartmentById(DepartmentDeleteDto departmentDeleteDto)
    {
        departmentRepository.deleteById(departmentDeleteDto.getId());
    }

    @Override
    public List<EmployeeDto> findAllEmployeesByDepartmentId(Long id) {
        return departmentRepository.findAllEmployeesByDeparmentId(id);
    }

}
