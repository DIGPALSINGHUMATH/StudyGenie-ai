package com.StudyGenie_ai.StudyGenie_ai.backend.dto.reqdto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor

public class FlashcardReqDto {
    private String Subject;
    private String frontText;
    private  String backText;
    private String source;

}
