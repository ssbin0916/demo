package com.example.demo.share;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareUserRepository extends JpaRepository<ShareUser, Long> {

    List<ShareUser> findByShareId(Long shareId);
}
