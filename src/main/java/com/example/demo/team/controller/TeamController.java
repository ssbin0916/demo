package com.example.demo.team.controller;

import com.example.demo.team.domain.Team;
import com.example.demo.team.domain.request.SaveTeamRequest;
import com.example.demo.team.domain.response.TeamResponse;
import com.example.demo.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    public final TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> save(@RequestBody Team team) {
        return ResponseEntity.ok(teamService.save(team));
    }

    @PostMapping("/addTeam")
    public ResponseEntity<Void> addTeam(@RequestBody SaveTeamRequest request) {
        teamService.addTeam(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<TeamResponse> findTeam(@PathVariable String name) {
        return ResponseEntity.ok(teamService.getTeamByName(name));
    }
}
