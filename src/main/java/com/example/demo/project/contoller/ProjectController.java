package com.example.demo.project.contoller;

import com.example.demo.project.domain.Project;
import com.example.demo.project.domain.request.SaveProjectRequest;
import com.example.demo.project.domain.response.SaveProjectResponse;
import com.example.demo.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<SaveProjectResponse> save(@RequestBody SaveProjectRequest request) {
        return ResponseEntity.ok(projectService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable String id) {
        return ResponseEntity.ok(projectService.findById(id));
    }

}
