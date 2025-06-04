package com.example.demo.department;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> save(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.save(departmentDto));
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Department> findById(Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }
}
