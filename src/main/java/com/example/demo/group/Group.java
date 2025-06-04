package com.example.demo.group;

import com.example.demo.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Table(name = "`groups`")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group extends BaseEntity {

    private String name;

    @Setter
    @Column(nullable = false)
    private boolean publicMembers;

    @Builder
    public Group(String name, boolean publicMembers) {
        this.name = name;
        this.publicMembers = publicMembers;
    }

}
