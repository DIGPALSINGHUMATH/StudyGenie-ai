package com.StudyGenie_ai.StudyGenie_ai.backend.Entity;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz.Quiz;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Student user;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subj subject;

    private String title;
    private String filePath;
    private Integer pageCount;
    private LocalDateTime importedAt;

    // Relationships
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocSummary> summaries;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes;
}

