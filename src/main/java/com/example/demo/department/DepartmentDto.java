package com.example.demo.department;

import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentDto {

    private String name;
    private List<Long> userIds;
}
