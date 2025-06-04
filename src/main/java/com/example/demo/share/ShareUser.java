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
@Table(name = "share_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShareUser extends BaseEntity {

    private Long userId;
    private Long shareId;

    @Builder
    public ShareUser(Long userId, Long shareId) {
        this.userId = userId;
        this.shareId = shareId;
    }
}
