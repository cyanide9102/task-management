package com.cyanide9102.taskmanagement.task.entity;

import com.cyanide9102.taskmanagement.common.entity.BaseEntity;
import com.cyanide9102.taskmanagement.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Column(nullable = false)
    private String title;

    private String description;

    private boolean completed = false;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User owner;
}
