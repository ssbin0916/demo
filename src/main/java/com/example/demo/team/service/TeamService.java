package com.example.demo.team.service;

import com.example.demo.team.domain.Team;
import com.example.demo.team.domain.response.TeamResponse;
import com.example.demo.team.repository.TeamRepository;
import com.example.demo.team.domain.request.SaveTeamRequest;
import com.example.demo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team save(Team team) {
        team = Team.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .name(team.getName())
                .build();

        teamRepository.save(team);

        return team;
    }

    public void addTeam(SaveTeamRequest request) {
        teamRepository.addTeam(request);
    }

    public TeamResponse getTeamByName(String name) {
        Team team = teamRepository.findByName(name);
        List<User> user = teamRepository.findUserByTeamName(name);
        return TeamResponse.from(team, user);
    }
}
