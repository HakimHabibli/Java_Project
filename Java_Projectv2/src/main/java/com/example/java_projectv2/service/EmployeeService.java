package com.example.java_projectv2.service;

import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.entity.EmployeeEntity;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import com.example.java_projectv2.mapper.EmployeeDtoMapper;
import com.example.java_projectv2.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    private final EmployeeRepository _employeeRepository;
    private final EmployeeDtoMapper _employeeDtoMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDtoMapper employeeDtoMapper) {
        _employeeRepository = employeeRepository;
        _employeeDtoMapper = employeeDtoMapper;
    }

    public List<EmployeeDto> getAllEmployees()
    {
        return _employeeRepository.findAll()
                .stream()
                .map(_employeeDtoMapper)
                .collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(int id)
    {
        return _employeeRepository.findById(id)
                .map(_employeeDtoMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        EmployeeEntity savedEntity =
                _employeeRepository.save(_employeeDtoMapper.toEntity(employeeDto));
        return _employeeDtoMapper.apply(savedEntity);
    }

    public void deleteEmployee(int id)
    {
        _employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(int id, EmployeeEntity updatedEmployee) {
        EmployeeEntity exist = _employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        exist.setName(updatedEmployee.getName());
        exist.setPosition(updatedEmployee.getPosition());
        exist.setSalary(updatedEmployee.getSalary());

        var savedEmployee =  _employeeRepository.save(exist);

        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getPosition(),
                savedEmployee.getName(),
                savedEmployee.getSalary());
    }
}
