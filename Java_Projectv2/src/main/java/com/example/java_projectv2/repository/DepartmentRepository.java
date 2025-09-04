package com.example.java_projectv2.repository;

import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.service.DepartmentService;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository
        extends JpaRepository<DepartmentEntity,Long>,CustomDepartmentRepository
{

}

