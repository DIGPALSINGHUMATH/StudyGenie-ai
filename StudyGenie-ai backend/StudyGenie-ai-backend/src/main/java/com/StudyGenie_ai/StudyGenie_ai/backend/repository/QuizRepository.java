package com.StudyGenie_ai.StudyGenie_ai.backend.repository;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findAllByDocument_DocId(Long docId);
}
