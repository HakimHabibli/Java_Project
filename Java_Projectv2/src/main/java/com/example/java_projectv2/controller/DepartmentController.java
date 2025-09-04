package com.example.java_projectv2.controller;


import com.example.java_projectv2.dto.EmployeeDto;
import com.example.java_projectv2.entity.DepartmentEntity;
import com.example.java_projectv2.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentController
{
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentEntity> getDepartments()
    {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeDto> getAllEmployeesByDepartmentId(@PathVariable long id) {
        return departmentService.findAllEmployeesByDepartmentId(id);
    }

    @GetMapping("id")
    public Optional<DepartmentEntity> getDepartmentById(@RequestParam long id)
    {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity department)
    {
        return departmentService.createDepartment(department);
    }


    @PutMapping
    public DepartmentEntity updateDepartment(@RequestBody DepartmentEntity department)
    {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping
    public void deleteDepartmentById(@RequestParam long id)
    {
        departmentService.deleteDepartmentById(id);
    }
}
