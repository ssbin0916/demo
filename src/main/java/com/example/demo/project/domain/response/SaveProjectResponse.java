package com.example.demo.project.domain.response;

import com.example.demo.project.domain.Project;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class SaveProjectResponse {

    private String name;
    private String teamId;
    private String userId;

    public static SaveProjectResponse of(Project project) {
        return new SaveProjectResponse(project.getName(), project.getTeamId(), project.getUserId());
    }
}
