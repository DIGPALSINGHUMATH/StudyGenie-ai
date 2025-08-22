package com.StudyGenie_ai.StudyGenie_ai.backend.Services.sercicesRepo;

import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentServiceRepo {


    Document uploadDocument(MultipartFile file, String subject) throws IOException;

    Document getDocumentById(Long id);
}
