package com.StudyGenie_ai.StudyGenie_ai.backend.Services.sercicesimp;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz.QuizOption;
import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.quiz.QuizQuestion;
import com.google.api.client.util.Value;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeminiAIService {

    private final ChatClient chatClient;

    public GeminiAIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Value("${gemini.api.key}")
    private String apiKey;

    // ------------------------------
    // PDF Text -> Summary
    // ------------------------------
    public String generateSummary(String content) {
        return chatClient.prompt()
                .user("Summarize this PDF text:\n" + content)
                .call()
                .content();
    }

    // ------------------------------
    // PDF Text -> Study Notes
    // ------------------------------
    public String generateNotes(String content) {
        return chatClient.prompt()
                .user("Create short study notes from:\n" + content)
                .call()
                .content();
    }

    // ------------------------------
    // PDF Text -> Quiz Text (raw)
    // ------------------------------
    public String generateQuizText(String content) {
        return chatClient.prompt()
                .user("Make 5 quiz questions with answers from:\n" + content)
                .call()
                .content();
    }

    // ------------------------------
    // PDF Text -> Quiz Questions (structured)
    // ------------------------------
    public List<QuizQuestion> generateQuizQuestions(String content) {
        List<QuizQuestion> questions = new ArrayList<>();

        // Example dummy question - replace with GPT parsed output if needed
        QuizQuestion q1 = QuizQuestion.builder()
                .qtype("MCQ")
                .prompt("What is AI?")
                .explanation("AI stands for Artificial Intelligence")
                .position(1)
                .options(List.of(
                        QuizOption.builder().optionText("Artificial Intelligence").isCorrect(true).build(),
                        QuizOption.builder().optionText("Another Option").isCorrect(false).build()
                ))
                .build();

        QuizQuestion q2 = QuizQuestion.builder()
                .qtype("MCQ")
                .prompt("Which of the following is a programming language?")
                .explanation("Java is a programming language")
                .position(2)
                .options(List.of(
                        QuizOption.builder().optionText("Java").isCorrect(true).build(),
                        QuizOption.builder().optionText("HTML").isCorrect(false).build()
                ))
                .build();

        questions.add(q1);
        questions.add(q2);

        return questions;
    }

    // ------------------------------
    // PDF Text -> Flashcards
    // ------------------------------
    public List<String[]> generateFlashcards(String content) {
        // Return List of {frontText, backText}
        List<String[]> flashcards = new ArrayList<>();
        flashcards.add(new String[]{"What is AI?", "Artificial Intelligence"});
        flashcards.add(new String[]{"What does JVM stand for?", "Java Virtual Machine"});
        return flashcards;
    }

    // ------------------------------
    // Async Example (if needed)
    // ------------------------------
    @Async
    public void processDocumentAsync(String content) {
        // Example async processing
        String summary = generateSummary(content);
        String notes = generateNotes(content);
        List<QuizQuestion> quiz = generateQuizQuestions(content);
        List<String[]> flashcards = generateFlashcards(content);

        // Save these results to DB or further processing
    }
}
