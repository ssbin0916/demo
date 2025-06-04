package com.example.demo.department;

import com.example.demo.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "department")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department extends BaseEntity {

    private String name;
    private List<String> usernames = new ArrayList<>();

    @Builder
    public Department(String name, List<String> usernames) {
        this.name = name;
        this.usernames = usernames;
    }
}
