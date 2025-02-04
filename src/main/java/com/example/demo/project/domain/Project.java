package com.example.demo.project.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Project {

    private String id;
    private String name;
    private LocalDateTime regDtm;

    private String teamId;
    private String userId;
}
