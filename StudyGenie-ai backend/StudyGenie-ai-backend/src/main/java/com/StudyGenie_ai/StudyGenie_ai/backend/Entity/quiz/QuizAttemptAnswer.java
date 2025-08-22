package com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz_attempt_answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizAttemptAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attemptAnswerId;

    @ManyToOne
    @JoinColumn(name = "attempt_id", nullable = false)
    private QuizAttempt attempt;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuizQuestion question;

    @ManyToOne
    @JoinColumn(name = "chosen_option_id")
    private QuizOption chosenOption;
}

