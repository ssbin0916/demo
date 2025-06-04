package com.example.demo.group_user_department;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupUserDepartmentRepository extends JpaRepository<GroupUserDepartment, Long> {

    List<GroupUserDepartment> findByGroupId(Long groupId);

    List<GroupUserDepartment> findByUserId(Long userId);

    List<GroupUserDepartment> findByDepartmentId(Long departmentId);
}
