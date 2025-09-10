package com.example.java_projectv2.controller;

import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.dto.employee.EmployeeCreateDto;
import com.example.java_projectv2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id)
    {
       return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeCreateDto> createEmployee(@Valid @RequestBody EmployeeCreateDto employee)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/by-department")
    public List<EmployeeDto> getEmployeesByDepartment(@RequestParam String departmentName) {
        return employeeService.getEmployeesByDepartmentName(departmentName);
    }
}


