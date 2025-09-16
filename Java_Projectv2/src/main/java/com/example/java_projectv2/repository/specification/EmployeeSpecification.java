package com.example.java_projectv2.repository.specification;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSpecification
{
    //TODO exchange for all employee entity
    public Specification<EmployeeEntity> hasDepartment(String departmentName)
    {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("department").get("departmentName"), departmentName);

    }
}
