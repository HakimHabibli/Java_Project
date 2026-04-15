package com.example.java_projectv2.controller;


import com.example.java_projectv2.dto.department.*;
import com.example.java_projectv2.dto.employee.EmployeeDto;
import com.example.java_projectv2.service.department.DepartmentService;
import jakarta.validation.Valid;
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
    public ResponseEntity< List<DepartmentGetDto>> getDepartments() {
        return ResponseEntity.ok().body(departmentService.getAllDepartments());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<DepartmentGetFilterDto>> getDepartmentWithFilter(DepartmentGetFilterDto filterDto) {
        return ResponseEntity.ok().body(departmentService.getDepartmentsByfilter(filterDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentGetDto> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok().body(departmentService.getDepartmentById(id));
    }


    @PostMapping
    public ResponseEntity<DepartmentCreateDto> createDepartment(@Valid @RequestBody DepartmentCreateDto department) {
        return ResponseEntity.ok().body(departmentService.createDepartment(department));
    }


    @PutMapping
    public ResponseEntity<DepartmentUpdateDto> updateDepartment(@Valid @RequestBody DepartmentUpdateDto department) {
        return  ResponseEntity.ok().body(departmentService.updateDepartment(department));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDepartmentById(@RequestBody DepartmentDeleteDto departmentDeleteDto) {
        departmentService.deleteDepartmentById(departmentDeleteDto);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesByDepartmentId(@PathVariable Long id) {

        return ResponseEntity.ok().body(departmentService.findAllEmployeesByDepartmentId(id));
    }

}
