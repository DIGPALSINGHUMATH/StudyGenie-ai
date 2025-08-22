package com.StudyGenie_ai.StudyGenie_ai.backend.Services.sercicesimp;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.*;
import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz.*;
import com.StudyGenie_ai.StudyGenie_ai.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final NoteRepository noteRepository;
    private final FlashcardRepository flashcardRepository;
    private final DocSummaryRepository docSummaryRepository;

    private final DocumentRepository documentRepository;
    private final QuizRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizOptionRepository quizOptionRepository;

    private final GeminiAIService geminiAIService;

    /**
     * Generate Notes, Flashcards, and Quiz for a document automatically
     */
    public void generateStudyMaterials(Document document) {

        String pdfContent = extractDocumentContent(document);

        // ---------------- Generate Note ----------------
        Note note = Note.builder()
                .user(document.getUser())
                .subject(document.getSubject())
                .document(document)
                .title("Auto Note: " + document.getTitle())
                .bodyMd(geminiAIService.generateNotes(pdfContent))
                .createdAt(LocalDateTime.now())
                .build();
        noteRepository.save(note);

        // ---------------- Generate Flashcards ----------------
        List<String[]> flashPairs = geminiAIService.generateFlashcards(pdfContent);
        for (String[] pair : flashPairs) {
            Flashcard flash = Flashcard.builder()
                    .user(document.getUser())
                    .subject(document.getSubject())
                    .frontText(pair[0])
                    .backText(pair[1])
                    .source("ai")
                    .createdAt(LocalDateTime.now())
                    .build();
            flashcardRepository.save(flash);
        }

        // ---------------- Generate Quiz ----------------
        Quiz quiz = Quiz.builder()
                .user(document.getUser())
                .subject(document.getSubject())
                .document(document)
                .title("Quiz: " + document.getTitle())
                .difficulty("medium")
                .createdAt(LocalDateTime.now())
                .build();
        quizRepository.save(quiz);

        List<QuizQuestion> questions = geminiAIService.generateQuizQuestions(pdfContent);
        for (QuizQuestion q : questions) {
            q.setQuiz(quiz);
            quizQuestionRepository.save(q);

            if (q.getOptions() != null) {
                for (QuizOption option : q.getOptions()) {
                    option.setQuestion(q);
                    quizOptionRepository.save(option);
                }
            }
        }
    }

    /**
     * Extract the content from the document entity
     */
    private String extractDocumentContent(Document document) {
        // TODO: Read PDF file if needed. For now placeholder
        return "Text content from PDF";
    }

    // ------------------------ Create Single Entities ------------------------

    public Note createNote(Long docId, String title, String body) {
        Document document = documentRepository.findById(docId)
                .orElseThrow(() -> new IllegalArgumentException("Document not found with id: " + docId));

        Note note = Note.builder()
                .user(document.getUser())
                .subject(document.getSubject())
                .document(document)
                .title(title)
                .bodyMd(body)
                .createdAt(LocalDateTime.now())
                .build();

        return noteRepository.save(note);
    }

    public Flashcard createFlashcard(Long docId, String front, String back, String source) {
        Document document = documentRepository.findById(docId)
                .orElseThrow(() -> new IllegalArgumentException("Document not found with id: " + docId));

        Flashcard flashcard = Flashcard.builder()
                .user(document.getUser())
                .subject(document.getSubject())
                .frontText(front)
                .backText(back)
                .source(source)
                .createdAt(LocalDateTime.now())
                .build();

        return flashcardRepository.save(flashcard);
    }

    public DocSummary createSummary(Long docId, String summaryText) {
        Document document = documentRepository.findById(docId)
                .orElseThrow(() -> new IllegalArgumentException("Document not found with id: " + docId));

        DocSummary summary = DocSummary.builder()
                .document(document)
                .summaryMd(summaryText)
                .build();

        return docSummaryRepository.save(summary);
    }
}
