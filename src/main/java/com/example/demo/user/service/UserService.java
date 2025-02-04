package com.example.demo.user.service;

import com.example.demo.team.domain.Team;
import com.example.demo.team.repository.TeamRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.reponse.UserResponse;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public User save(User user) {
        user = User.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .name(user.getName())
                .dept(user.getDept())
                .build();

        userRepository.save(user);
        return user;
    }

    public UserResponse getUserByName(String name) {
        User user = userRepository.findByName(name);
        List<Team> teams = teamRepository.findTeamsByUsername(name);
        return UserResponse.from(user, teams);
    }
}
