package com.example.demo.project.domain.request;

import lombok.Getter;

@Getter
public class SaveProjectRequest {

    private String name;
    private String teamId;
    private String userId;
}
