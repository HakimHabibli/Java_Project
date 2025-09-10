package com.example.java_projectv2.repository;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements CustomDepartmentRepository
{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EmployeeDto> findAllEmployeesByDeparmentId(Long id) {
        return em.createQuery(
                        "SELECT new com.example.java_projectv2.dto.employee.EmployeeDto(e.id, e.name, e.position,e.salary) " +
                                "FROM EmployeeEntity e " +
                                "WHERE e.department.id = :deptId", EmployeeDto.class)
                .setParameter("deptId", id)
                .getResultList();
    }


}