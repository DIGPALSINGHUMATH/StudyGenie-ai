package com.StudyGenie_ai.StudyGenie_ai.backend.repository;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findAllByDocument_DocId(Long docId);
}
