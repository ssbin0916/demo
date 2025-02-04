package com.example.demo.user.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class User {

    private String id;
    private String name;
    private String dept;
    private LocalDateTime regDtm;
}
