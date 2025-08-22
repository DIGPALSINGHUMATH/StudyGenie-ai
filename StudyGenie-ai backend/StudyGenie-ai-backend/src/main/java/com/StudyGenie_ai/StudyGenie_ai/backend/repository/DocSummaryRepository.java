package com.StudyGenie_ai.StudyGenie_ai.backend.repository;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.DocSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocSummaryRepository extends JpaRepository<DocSummary, Long> {
    Optional<DocSummary> findByDocument_DocId(Long docId);
}
