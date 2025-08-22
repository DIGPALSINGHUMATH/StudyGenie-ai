package com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Document;
import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Student;
import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Subj;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Student user;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subj subject;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Document document;

    private String title;
    private String difficulty;
    private LocalDateTime createdAt;

    // Relationships
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizQuestion> questions;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizAttempt> attempts;
}

