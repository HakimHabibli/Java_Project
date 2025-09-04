package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.dto.department.DepartmentGetDto;
import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.mapper.DepartmentMapper;
import com.example.java_projectv2.repository.DepartmentRepository;
import com.example.java_projectv2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<DepartmentEntity> getDepartmentById(long id)
    {
        return departmentRepository.findById(id);
    }

    @Override
    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity updateDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public void deleteDepartmentById(long id)
    {
         departmentRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findAllEmployeesByDepartmentId(long id) {
        return departmentRepository.findAllEmployeesByDeparmentId(id);
    }

}
