package com.StudyGenie_ai.StudyGenie_ai.backend.dto.respdto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SubjResdto {

    private  String name;
    private List<SubjResdto> allsubget ;

}
