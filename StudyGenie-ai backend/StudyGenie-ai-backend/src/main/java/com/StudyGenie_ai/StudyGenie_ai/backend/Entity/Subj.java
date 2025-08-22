package com.StudyGenie_ai.StudyGenie_ai.backend.Entity;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz.Quiz;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Student user;

    private String name;
    private String colorHex;

    // Relationships
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flashcard> flashcards;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;
}
