package com.StudyGenie_ai.StudyGenie_ai.backend.Controller;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Document;
import com.StudyGenie_ai.StudyGenie_ai.backend.Services.sercicesRepo.DocumentServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/Document")
@RequiredArgsConstructor
@CrossOrigin
public class DocumentControler {

    private final DocumentServiceRepo documentServiceRepo;


    @PostMapping("/upload")
    public  ResponseEntity<Document> uploadDoc(@RequestParam("file") MultipartFile file,
                                                               @RequestParam String subject) throws Exception {
        Document saved = documentServiceRepo.uploadDocument(file, subject);
        return ResponseEntity.ok(saved);
    }

    // Get document by ID
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        return ResponseEntity.ok(documentServiceRepo.getDocumentById(id));
    }




    }

