package com.StudyGenie_ai.StudyGenie_ai.backend.Controller;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.DocSummary;
import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Flashcard;
import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Note;
import com.StudyGenie_ai.StudyGenie_ai.backend.Services.sercicesimp.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study")
@RequiredArgsConstructor
@CrossOrigin
public class StudyController {

    private final StudyService studyService;

    @PostMapping("/note")
    public ResponseEntity<Note> createNote(
            @RequestParam Long docId,
            @RequestParam String title,
            @RequestParam String body) {
        return ResponseEntity.ok(studyService.createNote(docId, title, body));
    }

    @PostMapping("/flashcard")
    public ResponseEntity<Flashcard> createFlashcard(
            @RequestParam Long docId,
            @RequestParam String front,
            @RequestParam String back,
            @RequestParam(defaultValue = "ai") String source) {
        return ResponseEntity.ok(studyService.createFlashcard(docId, front, back, source));
    }

    @PostMapping("/summary")
    public ResponseEntity<DocSummary> createSummary(
            @RequestParam Long docId,
            @RequestParam String summaryText) {
        return ResponseEntity.ok(studyService.createSummary(docId, summaryText));
    }
}

