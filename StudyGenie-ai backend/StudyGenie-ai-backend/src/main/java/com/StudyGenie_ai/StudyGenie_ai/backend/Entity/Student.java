package com.StudyGenie_ai.StudyGenie_ai.backend.Entity;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz.Quiz;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "app_user") // <-- not reserved
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")           // good DB naming
    private Long userId;                // avoid capitalized field names

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subj> subjects;     // use your actual entity type

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flashcard> flashcards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;
}
