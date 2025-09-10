package com.example.java_projectv2.rules;

import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.exception.BusinessException;
import com.example.java_projectv2.exception.NotNullException;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.repository.DepartmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentRules extends BaseRules<DepartmentEntity>
{
    private final DepartmentRepository departmentRepository;
    public DepartmentRules(JpaRepository<DepartmentEntity,Long> repository, DepartmentRepository departmentRepository) {
        super(repository);
        this.departmentRepository = departmentRepository;
    }


    /**
     *
     * @param id the department entity id
     * @throws ResourceNotFoundException if the entity is exits
     */
    @Override
    public void checkIfExistsById(Long id) {
        if(!repository.existsById(id)){throw new ResourceNotFoundException("Department with id " + id + " does not exist");}
    }


    /**
     * Checks whether the Department entity and its required fields are null.
     *
     * @param obj the department entity to validate
     * @throws NotNullException if the entity itself or its departmentName is null
     */
    @Override
    public void checkNotNull(DepartmentEntity obj)
    {
        if(obj == null) throw new NotNullException("DepartmentEntity is null");
        if(obj.getDepartmentName() == null) throw new NotNullException("Department name is null");
    }

    /**
     *
     * @param obj the department entity to validate
     * @throws BusinessException if the entity name is unique
     */
    @Override
    public void checkIfUnique(DepartmentEntity obj) {
        if (departmentRepository.existsByDepartmentName(obj.getDepartmentName())) {
            throw new BusinessException("Department name is already in use");
        }

    }

}
