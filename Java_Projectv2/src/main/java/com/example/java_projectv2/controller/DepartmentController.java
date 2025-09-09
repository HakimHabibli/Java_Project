package com.example.java_projectv2.controller;


import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.dto.department.DepartmentCreateDto;
import com.example.java_projectv2.dto.department.DepartmentDeleteDto;
import com.example.java_projectv2.dto.department.DepartmentGetDto;
import com.example.java_projectv2.dto.department.DepartmentUpdateDto;
import com.example.java_projectv2.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController
{
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentGetDto> getDepartments()
    {
        return departmentService.getAllDepartments();
    }

    @GetMapping("{id}")
    public DepartmentGetDto getDepartmentById(@PathVariable long id)
    {
        return departmentService.getDepartmentById(id);
    }


    @PostMapping
    public DepartmentCreateDto createDepartment(@RequestBody DepartmentCreateDto department)
    {
        return departmentService.createDepartment(department);
    }


    @PutMapping
    public DepartmentUpdateDto updateDepartment(@RequestBody DepartmentUpdateDto department)
    {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDepartmentById(@RequestBody DepartmentDeleteDto departmentDeleteDto)
    {
        departmentService.deleteDepartmentById(departmentDeleteDto);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeDto> getAllEmployeesByDepartmentId(@PathVariable long id) {
        return departmentService.findAllEmployeesByDepartmentId(id);
    }

}
