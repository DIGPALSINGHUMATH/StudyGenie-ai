package com.StudyGenie_ai.StudyGenie_ai.backend.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student user;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Document document;

    private String title;
    @Lob
    private String bodyMd;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

