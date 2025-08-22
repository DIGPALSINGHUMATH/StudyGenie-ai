package com.StudyGenie_ai.StudyGenie_ai.backend.dto.respdto;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class StudentRespDto {

    private Long id;
    private String fullname;
    private String email;
    private List<SubjResdto> Subject;

}
