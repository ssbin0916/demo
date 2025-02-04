package com.example.demo.project.service;

import com.example.demo.project.domain.Project;
import com.example.demo.project.domain.repository.ProjectRepository;
import com.example.demo.project.domain.request.SaveProjectRequest;
import com.example.demo.project.domain.response.SaveProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public SaveProjectResponse save(SaveProjectRequest request) {
        Project project = Project.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .name(request.getName())
                .teamId(request.getTeamId())
                .userId(request.getUserId())
                .build();

        Project save = projectRepository.save(project);

        return SaveProjectResponse.of(save);
    }

    public Project findById(String id) {
        return projectRepository.findById(id);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
