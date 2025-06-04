package com.example.demo.group_user_department;

import com.example.demo.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "group_user_department")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupUserDepartment extends BaseEntity {

    private Long groupId;
    private Long userId;
    private Long departmentId;

    @Builder
    public GroupUserDepartment(Long groupId, Long userId, Long departmentId) {
        this.groupId = groupId;
        this.userId = userId;
        this.departmentId = departmentId;
    }
}
