package com.example.demo.project.domain;

import com.example.demo.team.domain.Team;
import com.example.demo.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProjectDao {

    private String id;
    private String name;
    private String teamId;
    private String userId;
    private List<Team> teams;
    private List<User> users;
}
