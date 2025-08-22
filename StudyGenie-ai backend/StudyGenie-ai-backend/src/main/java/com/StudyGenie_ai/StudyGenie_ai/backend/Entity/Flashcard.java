package com.StudyGenie_ai.StudyGenie_ai.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flashcard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flashId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Student user;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subj subject;

    private String frontText;
    private String backText;
    private String source; // user/ai/manual
    private LocalDateTime createdAt;
}

