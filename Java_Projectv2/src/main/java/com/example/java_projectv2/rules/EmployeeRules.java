package com.example.java_projectv2.rules;

import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.entity.EmployeeEntity;
import com.example.java_projectv2.exception.BusinessException;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Service
public class EmployeeRules extends BaseRules<EmployeeEntity>
{
    private final EmployeeRepository employeeRepository;

    public EmployeeRules(JpaRepository<EmployeeEntity,Long> repository, EmployeeRepository employeeRepository) {
        super(repository);
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void checkIfExistsById(Long id)
    {
        if(!repository.existsById(id)){throw new ResourceNotFoundException("Employee with id " + id + " does not exist");}
    }

    @Override
    public void checkIfUnique(EmployeeEntity obj) {
        if(employeeRepository.existsByFinCode(obj.getFinCode()))
        {
            throw new BusinessException("Employee with Fin Code " + obj.getFinCode() + " already exists");
        }
    }



}

