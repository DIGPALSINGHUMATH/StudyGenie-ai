package com.StudyGenie_ai.StudyGenie_ai.backend.dto.respdto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocumentResDto {
    private Long docId;
    private String title;
    private String filePath;
    private String importedAt;

    private String summary;
    private String notes;
    private String quiz;
}
