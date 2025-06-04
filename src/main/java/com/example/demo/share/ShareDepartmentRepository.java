package com.example.demo.share;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareDepartmentRepository extends JpaRepository<ShareDepartment, Long> {

    List<ShareDepartment> findByShareId(Long shareId);
}
