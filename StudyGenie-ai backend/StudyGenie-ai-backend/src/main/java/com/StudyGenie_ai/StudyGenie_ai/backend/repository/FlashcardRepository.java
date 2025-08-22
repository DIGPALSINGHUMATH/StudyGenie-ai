package com.StudyGenie_ai.StudyGenie_ai.backend.repository;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
}
