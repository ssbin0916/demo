package com.example.demo.user.domain.reponse;

import com.example.demo.team.domain.Team;
import com.example.demo.team.domain.dto.TeamDto;
import com.example.demo.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class UserResponse {

    private String name;
    private String dept;
    private LocalDateTime regDtm;
    private List<TeamDto> teams;

    public static UserResponse from(User user, List<Team> teams) {
        List<TeamDto> teamDtoList = teams.stream()
                .map(team -> new TeamDto(team.getName()))
                .toList();

        return UserResponse.builder()
                .name(user.getName())
                .dept(user.getDept())
                .regDtm(user.getRegDtm())
                .teams(teamDtoList)
                .build();
    }
}
