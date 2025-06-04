package com.example.demo.share;

import com.example.demo.department.Department;
import com.example.demo.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shares")
@RequiredArgsConstructor
public class ShareController {

    private final ShareService shareService;

    @GetMapping("/{shareId}/users")
    public ResponseEntity<List<User>> getUsers(@PathVariable Long shareId) {
        List<User> users = shareService.getAllSharedUsers(shareId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{shareId}/departments")
    public ResponseEntity<List<Department>> getDepartments(@PathVariable Long shareId) {
        List<Department> departments = shareService.getAllSharedDepartments(shareId);
        return ResponseEntity.ok(departments);
    }
}
