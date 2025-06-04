package com.example.demo.user;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void init() {
        String[] names = {
                "유저1",
                "유저2",
                "유저3",
                "유저4",
                "유저5"
        };

        for (String name : names) {
            User user = User.builder()
                    .username(name)
                    .build();
            userRepository.save(user);
        }
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
