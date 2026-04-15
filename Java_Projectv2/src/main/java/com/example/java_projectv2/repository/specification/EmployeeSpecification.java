package com.example.java_projectv2.repository.specification;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.dto.employee.GetEmployeeSpecificationDto;
import com.example.java_projectv2.entity.EmployeeEntity;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSpecification
{
    public Specification<EmployeeEntity> getEmployeeSpecification
            (GetEmployeeSpecificationDto dto)
    {
        Specification<EmployeeEntity> spec =
                (root, query, cb) -> cb.conjunction();

        if(dto.getName()!=null && !dto.getName().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder)
                    -> criteriaBuilder.equal(root.get("name"), dto.getName()));
        }
        if(dto.getPosition()!=null && !dto.getPosition().isEmpty()) {
            spec = spec.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("position"), dto.getPosition())));
        }
        if (dto.getMinSalary()!=null && dto.getMaxSalary()!=null) {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.between(root.get("salary"), dto.getMinSalary(), dto.getMaxSalary()));
        } else if (dto.getMaxSalary()!= null)
            {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.greaterThan(root.get("salary"), dto.getMaxSalary())
                        );
            }
          else if (dto.getMinSalary()!= null)
            {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.lessThan(root.get("salary"), dto.getMinSalary()));
            }

        if (dto.getFinCode() != null && !dto.getFinCode().isEmpty()) {
                spec = spec.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("finCode"), dto.getFinCode()));
        }

        return spec;

    }

    //TODO exchange for all employee entity
    public Specification<EmployeeEntity> hasDepartment(String departmentName)
    {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("department").get("departmentName"), departmentName);

    }
}
