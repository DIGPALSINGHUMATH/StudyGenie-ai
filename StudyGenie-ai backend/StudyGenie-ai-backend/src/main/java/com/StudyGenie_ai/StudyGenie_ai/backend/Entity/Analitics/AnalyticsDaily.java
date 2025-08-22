package com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Analitics;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "analytics_daily")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyticsDaily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private Integer notesViewed;
    private Integer tasksCompleted;
    private Integer quizzesTaken;
}

