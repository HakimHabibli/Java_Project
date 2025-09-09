package com.example.java_projectv2.repository;

import com.example.java_projectv2.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository
    extends IGenericRepository<EmployeeEntity, Integer>
{
    public List<EmployeeEntity> findByDepartment_DepartmentName(String departmentName);

}
