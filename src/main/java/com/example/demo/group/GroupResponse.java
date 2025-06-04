package com.example.demo.group;

import com.example.demo.department.Department;
import com.example.demo.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class GroupResponse {

    private Long id;
    private String name;
    private boolean publicMembers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<User> users;
    private List<Department> departments;

    public GroupResponse(Long id, String name, boolean publicMembers, LocalDateTime createdAt, LocalDateTime updatedAt, List<User> users, List<Department> departments) {
        this.id = id;
        this.name = name;
        this.publicMembers = publicMembers;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.users = users;
        this.departments = departments;
    }
}
