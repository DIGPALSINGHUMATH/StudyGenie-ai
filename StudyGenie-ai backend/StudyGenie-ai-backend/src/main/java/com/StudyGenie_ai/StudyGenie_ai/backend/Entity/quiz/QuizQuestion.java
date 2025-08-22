package com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "quiz_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    private String qtype;
    private String prompt;
    private String explanation;
    private Integer position;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizOption> options;
}

