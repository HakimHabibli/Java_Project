package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository)
    {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentEntity> getAllDepartments()
    {
        return departmentRepository.findAll();
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
