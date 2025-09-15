package com.example.java_projectv2.repository.employee;

import com.example.java_projectv2.entity.EmployeeEntity;
import com.example.java_projectv2.repository.base.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository
    extends IGenericRepository<EmployeeEntity, Long>
{
    public List<EmployeeEntity> findByDepartment_DepartmentName(String departmentName);
    boolean existsByFinCode(String employeeFinCode);
}
