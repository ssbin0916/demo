package com.example.demo.group;

import java.util.List;

public record GroupRequest(
        String name,
        boolean publicMembers,
        List<MemberDto> members
) {

    public record MemberDto(
            Long userId,
            Long departmentId
    ) {
    }
}
