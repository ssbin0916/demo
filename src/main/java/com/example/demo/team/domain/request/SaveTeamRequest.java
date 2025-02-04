package com.example.demo.team.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveTeamRequest {

    private String teamId;
    private String userId;
}
