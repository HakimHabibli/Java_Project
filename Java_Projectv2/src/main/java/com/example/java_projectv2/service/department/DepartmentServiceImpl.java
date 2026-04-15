package com.example.java_projectv2.service.department;

import com.example.java_projectv2.dto.department.*;
import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.mapper.DepartmentMapper;
import com.example.java_projectv2.repository.department.DepartmentRepository;
import com.example.java_projectv2.repository.specification.DepartmentSpecification;
import com.example.java_projectv2.rules.DepartmentRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final DepartmentRules departmentRules;
    private final DepartmentSpecification departmentSpecification;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper, DepartmentRules departmentRules, DepartmentSpecification departmentSpecification) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.departmentRules = departmentRules;
        this.departmentSpecification = departmentSpecification;
    }

    @Override
    public List<DepartmentGetFilterDto> getDepartmentsByfilter(DepartmentGetFilterDto dto) {
        Specification<DepartmentEntity> entitySpec = departmentSpecification.DepartmentSpecification(dto);
        var entities = departmentRepository.findAll(entitySpec);
        return departmentMapper.toDepartmentGetFilterDtoList(entities);
    }

    @Override
    public List<DepartmentGetDto> getAllDepartments() {
        var entity =  departmentRepository.findAll();
        return departmentMapper.toGetDepartmentDtoList(entity);
    }

    @Override
    public DepartmentGetDto getDepartmentById(Long id) {
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

        //Business check
        departmentRules.checkNotNull(entity);
        departmentRules.checkIfUnique(entity);


        departmentRepository.save(entity);

        return departmentMapper.toDepartmentUpdateDto(entity);
    }

    @Override
    public void deleteDepartmentById(DepartmentDeleteDto departmentDeleteDto) {
        departmentRepository.deleteById(departmentDeleteDto.getId());
    }

    @Override
    public List<EmployeeDto> findAllEmployeesByDepartmentId(Long id) {
        return departmentRepository.findAllEmployeesByDepartmentId(id);
    }

}
