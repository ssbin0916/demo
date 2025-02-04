package com.example.demo.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDto {

    private String name;
    private String dept;
    private LocalDateTime regDtm;


}