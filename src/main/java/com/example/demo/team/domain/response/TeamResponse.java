package com.example.demo.team.domain.response;

import com.example.demo.team.domain.Team;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.dto.UserDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class TeamResponse {

    private String name;
    private List<UserDto> users;

    public static TeamResponse from(Team team, List<User> users) {
        List<UserDto> userDtoList = users.stream()
                .map(user -> new UserDto(user.getName(), user.getDept(), user.getRegDtm()))
                .collect(Collectors.toList());

        return TeamResponse.builder()
                .name(team.getName())
                .users(userDtoList)
                .build();
    }
}
