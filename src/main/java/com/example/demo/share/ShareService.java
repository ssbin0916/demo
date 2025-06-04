package com.example.demo.share;

import com.example.demo.department.Department;
import com.example.demo.department.DepartmentRepository;
import com.example.demo.group_user_department.GroupUserDepartment;
import com.example.demo.group_user_department.GroupUserDepartmentRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShareService {

    private final ShareRepository shareRepository;
    private final GroupUserDepartmentRepository groupUserDepartmentRepository;
    private final ShareUserRepository shareUserRepository;
    private final ShareDepartmentRepository shareDepartmentRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public List<User> getAllSharedUsers(Long shareId) {

        Share share = shareRepository.findById(shareId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Share: " + shareId));

        Long groupId = share.getGroupId();

        Set<Long> groupUserIds = groupUserDepartmentRepository.findByGroupId(groupId).stream()
                .map(GroupUserDepartment::getUserId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        Set<Long> extraUserIds = shareUserRepository.findByShareId(shareId).stream()
                .map(ShareUser::getUserId)
                .collect(Collectors.toSet());

        groupUserIds.addAll(extraUserIds);
        if (groupUserIds.isEmpty()) {
            return Collections.emptyList();
        }

        return userRepository.findAllById(groupUserIds);
    }

    public List<Department> getAllSharedDepartments(Long shareId) {

        Share share = shareRepository.findById(shareId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Share: " + shareId));
        Long groupId = share.getGroupId();

        // 2) 그룹 멤버(부서) ID
        Set<Long> groupDeptIds = groupUserDepartmentRepository.findByGroupId(groupId).stream()
                .map(GroupUserDepartment::getDepartmentId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        // 3) 추가 지정된 부서 ID
        Set<Long> extraDeptIds = shareDepartmentRepository.findByShareId(shareId).stream()
                .map(ShareDepartment::getDepartmentId)
                .collect(Collectors.toSet());

        groupDeptIds.addAll(extraDeptIds);
        if (groupDeptIds.isEmpty()) {
            return Collections.emptyList();
        }

        // 4) Department 조회
        return departmentRepository.findAllById(groupDeptIds);
    }
}
