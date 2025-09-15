package com.example.java_projectv2.repository.department;

import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.repository.base.IGenericRepository;

public interface DepartmentRepository
        extends IGenericRepository<DepartmentEntity,Long>,CustomDepartmentRepository
{
     boolean existsByDepartmentName(String departmentName);

}

