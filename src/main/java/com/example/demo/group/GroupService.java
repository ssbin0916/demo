package com.example.demo.group;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {


    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final GroupUserDepartmentRepository groupUserDepartmentRepository;

    @Transactional
    public Group save(GroupRequest groupRequest) {

        Group group = Group.builder()
                .name(groupRequest.name())
                .publicMembers(groupRequest.publicMembers())
                .build();

        group = groupRepository.save(group);
        Long groupId = group.getId();

        if (groupRequest.members() != null) {
            groupRequest.members().forEach(member -> {
                Long userId = member.userId();
                Long departmentId = member.departmentId();

                GroupUserDepartment groupUserDepartment = GroupUserDepartment.builder()
                        .groupId(groupId)
                        .userId(userId)
                        .departmentId(departmentId)
                        .build();

                groupUserDepartmentRepository.save(groupUserDepartment);
            });
        }
        return group;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public GroupResponse findById(Long id) {

        Group group = groupRepository.findById(id).orElse(null);
        if (group == null) {
            return null;
        }

        boolean isPublic = group.isPublicMembers();

        List<User> users = Collections.emptyList();
        List<Department> departments = Collections.emptyList();


        if (isPublic) {
            List<GroupUserDepartment> mappings = groupUserDepartmentRepository.findByGroupId(id);

            Set<Long> userIds = new HashSet<>();
            Set<Long> departmentIds = new HashSet<>();

            for (GroupUserDepartment groupUserDepartment : mappings) {
                if (groupUserDepartment.getUserId() != null) {
                    userIds.add(groupUserDepartment.getUserId());
                }

                if (groupUserDepartment.getDepartmentId() != null) {
                    departmentIds.add(groupUserDepartment.getDepartmentId());
                }
            }

            if (!userIds.isEmpty()) {
                users = userRepository.findAllById(userIds);
            }

            if (!departmentIds.isEmpty()) {
                departments = departmentRepository.findAllById(departmentIds);
            }
        }
        return new GroupResponse(
                group.getId(),
                group.getName(),
                isPublic,
                group.getCreatedAt(),
                group.getUpdatedAt(),
                users,
                departments
        );
    }
}
