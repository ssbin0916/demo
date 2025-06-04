package com.example.demo.share;

import com.example.demo.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "share_department")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShareDepartment extends BaseEntity {

    private Long shareId;
    private Long departmentId;

    @Builder
    public ShareDepartment(Long shareId, Long departmentId) {
        this.shareId = shareId;
        this.departmentId = departmentId;
    }
}
