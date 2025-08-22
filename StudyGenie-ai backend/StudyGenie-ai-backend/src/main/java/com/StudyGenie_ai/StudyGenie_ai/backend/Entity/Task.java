package com.StudyGenie_ai.StudyGenie_ai.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Student user;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subj subject;

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private Boolean marked;

    @Column(columnDefinition = "jsonb")
    private String meta; // for extra metadata (PostgreSQL JSONB)
}

