package com.example.java_projectv2.repository.specification;

import com.example.java_projectv2.dto.department.DepartmentGetFilterDto;
import com.example.java_projectv2.dto.employee.GetEmployeeSpecificationDto;
import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.entity.EmployeeEntity;
import com.example.java_projectv2.repository.employee.EmployeeRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


//TODO Change to switch-case
@Service
public class DepartmentSpecification
{

    public Specification<DepartmentEntity> DepartmentSpecification(DepartmentGetFilterDto dto)
    {
        Specification<DepartmentEntity> spec = (root, query, cb)
                -> cb.conjunction();
        if(dto.getDepartmentName() != null && !dto.getDepartmentName().isEmpty())
        {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("departmentName"), dto.getDepartmentName()));
        }


        if(dto.getEmployees() != null )
        {
            if(dto.getEmployees().getName()!=null && !dto.getEmployees().getName().isEmpty())
                {
                    spec = spec.and((root, query, criteriaBuilder) ->
                    {
                        Join<Object, Object> employees = root.join("employees", JoinType.INNER);
                        return criteriaBuilder.equal(employees.get("name"), dto.getEmployees().getName());
                    });
                }
                if(dto.getEmployees().getFinCode()!=null && !dto.getEmployees().getFinCode().isEmpty())
                {
                    spec = spec.and((root, query, criteriaBuilder) ->
                    {
                                Join<Object, Object> employees = root.join("employees", JoinType.INNER);
                               return criteriaBuilder.equal(root.get("finCode"), dto.getEmployees().getFinCode());
                    });
                }
                if(dto.getEmployees().getPosition()!=null && !dto.getEmployees().getPosition().isEmpty())
                {
                    spec = spec.and((root, query, criteriaBuilder) ->
                    {
                        Join<Object, Object> employees = root.join("employees", JoinType.INNER);
                        return criteriaBuilder.equal(root.get("position"), dto.getEmployees().getPosition());
                    });
                }
                if(dto.getEmployees().getMaxSalary()!=null && dto.getEmployees().getMinSalary()!=null)
                {
                    spec = spec.and((root, query, criteriaBuilder) ->
                    {
                        Join<Object, Object> employees = root.join("employees", JoinType.INNER);
                        return criteriaBuilder.between(root.get("salary"), dto.getEmployees().getMinSalary(), dto.getEmployees().getMaxSalary());
                    });
                }
                    else if (dto.getEmployees().getMaxSalary()!=null )
                    {
                    spec = spec.and((root, query, criteriaBuilder) ->
                    {
                        Join<Object, Object> employees = root.join("employees", JoinType.INNER);
                        return criteriaBuilder.lessThanOrEqualTo(root.get("salary"), dto.getEmployees().getMaxSalary());
                    });
                }
                    else if (dto.getEmployees().getMinSalary()!=null )
                    {
                    spec = spec.and((root, query, criteriaBuilder) ->
                        {
                            Join<Object, Object> employees = root.join("employees", JoinType.INNER);
                            return criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), dto.getEmployees().getMinSalary());
                        });
                }
        }


        return spec;
    }
}
