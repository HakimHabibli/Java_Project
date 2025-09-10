package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.dto.employee.EmployeeCreateDto;
import com.example.java_projectv2.entity.EmployeeEntity;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.mapper.EmployeeDtoMapper;
import com.example.java_projectv2.repository.EmployeeRepository;
import com.example.java_projectv2.rules.EmployeeRules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    private final EmployeeRepository _employeeRepository;
    private final EmployeeDtoMapper _employeeDtoMapper;
    private final EmployeeRules _employeeRules;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDtoMapper employeeDtoMapper, EmployeeRules employeeRules) {
        _employeeRepository = employeeRepository;
        _employeeDtoMapper = employeeDtoMapper;
        _employeeRules = employeeRules;
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
        return _employeeRepository.findById(id)
                .map(_employeeDtoMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public EmployeeCreateDto createEmployee(EmployeeCreateDto employeeCreateDto)
    {
        var entity = _employeeDtoMapper.toEntity(employeeCreateDto);
        _employeeRules.checkIfUnique(entity);
        _employeeRepository.save(entity);
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
        exist.setFinCode(updatedEmployeeDto.finCode());

        var savedEmployee =  _employeeRepository.save(exist);

        return _employeeDtoMapper.apply(savedEmployee);
    }

    public List<EmployeeDto> getEmployeesByDepartmentName(String departmentName)
    {
        var entity =  _employeeRepository.findByDepartment_DepartmentName(departmentName);
        return  _employeeDtoMapper.toEntityList(entity);
    }
}
