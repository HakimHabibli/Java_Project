package com.example.java_projectv2.service.employee;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.dto.employee.EmployeeCreateDto;
import com.example.java_projectv2.entity.EmployeeEntity;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.mapper.EmployeeDtoMapper;
import com.example.java_projectv2.repository.employee.EmployeeRepository;
import com.example.java_projectv2.repository.specification.EmployeeSpecification;
import com.example.java_projectv2.rules.EmployeeRules;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    private final EmployeeRepository _employeeRepository;
    private final EmployeeDtoMapper _employeeDtoMapper;
    private final EmployeeRules _employeeRules;
    private final EmployeeSpecification _employeeSpecification;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDtoMapper employeeDtoMapper, EmployeeRules employeeRules, EmployeeSpecification employeeSpecification) {
        _employeeRepository = employeeRepository;
        _employeeDtoMapper = employeeDtoMapper;
        _employeeRules = employeeRules;
        _employeeSpecification = employeeSpecification;
    }

    public List<EmployeeDto>  getFilteredEmployees(String departmentName) {

        Specification<EmployeeEntity> departmentSpec = _employeeSpecification.hasDepartment(departmentName);

        List<EmployeeEntity> employees = _employeeRepository.findAll(departmentSpec);

        return _employeeDtoMapper.toEntityList(employees);
    }
    public List<EmployeeDto> getAllEmployees()
    {
        return _employeeRepository.findAll()
                .stream()
                .map(_employeeDtoMapper)
                .collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(Long id)
    {
        return _employeeRepository
                .findById(id)
                .map(_employeeDtoMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public EmployeeCreateDto createEmployee(EmployeeCreateDto employeeCreateDto)
    {

        var entity = _employeeDtoMapper.toEntity(employeeCreateDto);


        entity.setFinCode(entity.getFinCode().toUpperCase());

        //BussinessRule
        _employeeRules.checkIfUnique(entity);

        //Save entity db
        _employeeRepository.save(entity);

        //Return value
        return _employeeDtoMapper.toEmployeeCreateDto(entity);
    }

    public void deleteEmployee(Long id)
    {
        _employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(EmployeeDto updatedEmployeeDto)
    {
        EmployeeEntity exist = _employeeRepository.findById(updatedEmployeeDto.id())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        exist.setName(updatedEmployeeDto.name());
        exist.setPosition(updatedEmployeeDto.position());
        exist.setSalary(updatedEmployeeDto.salary());
        exist.setFinCode(updatedEmployeeDto.finCode().toUpperCase());

        var savedEmployee =  _employeeRepository.save(exist);

        return _employeeDtoMapper.apply(savedEmployee);
    }

    public List<EmployeeDto> getEmployeesByDepartmentName(String departmentName)
    {
        var entity =  _employeeRepository.findByDepartment_DepartmentName(departmentName);
        return _employeeDtoMapper.toEntityList(entity);
    }
}
