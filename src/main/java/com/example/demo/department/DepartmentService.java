package com.example.demo.department;

import com.example.demo.user.User;
import com.example.demo.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final UserService userService;

    @Transactional
    public Department save(DepartmentDto departmentDto) {
        List<String> usernames = new ArrayList<>();
        for (Long userId : departmentDto.getUserIds()) {
            User user = userService.findById(userId);
            usernames.add(user.getUsername());
        }

        Department department = Department.builder()
                .name(departmentDto.getName())
                .usernames(usernames)
                .build();

        return departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
