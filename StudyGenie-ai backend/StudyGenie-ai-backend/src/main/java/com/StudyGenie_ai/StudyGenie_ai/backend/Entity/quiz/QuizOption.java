package com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz_option")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuizQuestion question;

    private String optionText;
    private Boolean isCorrect;
}

