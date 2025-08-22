package com.StudyGenie_ai.StudyGenie_ai.backend.dto.reqdto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@RequiredArgsConstructor
public class DocumentReqDto {
    private Long docId;
    private String title;
    private String filePath;
    private String importedAt;

    private String summary;
    private String notes;
    private String quiz;

}
