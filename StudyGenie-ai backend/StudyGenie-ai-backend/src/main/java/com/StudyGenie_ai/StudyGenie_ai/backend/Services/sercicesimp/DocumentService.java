package com.StudyGenie_ai.StudyGenie_ai.backend.Services.sercicesimp;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Document;
import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Subj;
import com.StudyGenie_ai.StudyGenie_ai.backend.Services.sercicesRepo.DocumentServiceRepo;
import com.StudyGenie_ai.StudyGenie_ai.backend.repository.DocumentRepository;
import com.StudyGenie_ai.StudyGenie_ai.backend.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DocumentService implements DocumentServiceRepo {

    private final DocumentRepository documentRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public Document uploadDocument(MultipartFile file, String subjectName) throws IOException {
        // ✅ Find Subject by name
        Subj subject = (Subj) subjectRepository.findByName(subjectName)
                .orElseThrow(() -> new RuntimeException("Subject not found: " + subjectName));

        // ✅ Save PDF file locally
        String filePath = "uploads/" + file.getOriginalFilename();
        File dest = new File(filePath);
        dest.getParentFile().mkdirs();
        file.transferTo(dest);

        // ✅ Extract text from PDF
        String extractedText;
        try (PDDocument pdfDoc = PDDocument.load(file.getInputStream())) {
            PDFTextStripper stripper = new PDFTextStripper();
            extractedText = stripper.getText(pdfDoc);
        }

        // ✅ Build and save Document entity
        Document document = Document.builder()
                .title(file.getOriginalFilename())
                .filePath(filePath)
                .importedAt(LocalDateTime.now())
                .subject(subject)
                .build();

        return documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Document id nto find"));
    }
}
