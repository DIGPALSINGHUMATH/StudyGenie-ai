package com.StudyGenie_ai.StudyGenie_ai.backend.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "doc_summary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long summaryId;

    @ManyToOne
    @JoinColumn(name = "doc_id", nullable = false)
    private Document document;

    private String modelName;
    @Lob
    private String summaryMd;
    private LocalDateTime createdAt;
}

