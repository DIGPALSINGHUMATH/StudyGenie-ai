package com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz_attempt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attemptId;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private Double scorePct;

    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizAttemptAnswer> answers;
}

