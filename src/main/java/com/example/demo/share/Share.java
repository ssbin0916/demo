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
@Table(name = "share")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Share extends BaseEntity {

    private Long groupId;

    @Builder
    public Share(Long groupId) {
        this.groupId = groupId;
    }
}
