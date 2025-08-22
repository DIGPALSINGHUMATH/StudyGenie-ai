package com.StudyGenie_ai.StudyGenie_ai.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentReq {
    private  String name;

    @Email
    @NotNull
    private String email;

    private String password;

}
