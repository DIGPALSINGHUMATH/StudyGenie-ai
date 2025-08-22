package com.StudyGenie_ai.StudyGenie_ai.backend.dto.reqdto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class StudentReqDto {
 private  String fullname;
 private  String email;
}
