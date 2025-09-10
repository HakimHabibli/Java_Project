package com.example.java_projectv2.repository;

import com.example.java_projectv2.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends IGenericRepository<DepartmentEntity,Long>,CustomDepartmentRepository
{
     boolean existsByDepartmentName(String departmentName);

}

