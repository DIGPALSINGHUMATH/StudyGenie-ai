package com.StudyGenie_ai.StudyGenie_ai.backend.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModalConfig {

    @Bean
    public  ModelMapper ModelMapper(){
        return new  ModelMapper();
    }
}
