package com.example.demo.user.service;

import com.example.demo.user.domain.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        user = User.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .name(user.getName())
                .dept(user.getDept())
                .build();

        userRepository.save(user);
        return user;
    }
}
