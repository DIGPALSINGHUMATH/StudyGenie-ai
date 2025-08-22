package com.StudyGenie_ai.StudyGenie_ai.backend.repository;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByDocument_DocId(Long docId);
}
