package com.StudyGenie_ai.StudyGenie_ai.backend.repository;


import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Subj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subj, Long> {
    Optional<Subj> findByName(String name);
}
