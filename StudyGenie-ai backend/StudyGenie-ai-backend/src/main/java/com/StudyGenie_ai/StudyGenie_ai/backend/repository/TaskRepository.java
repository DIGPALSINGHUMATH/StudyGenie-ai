package com.StudyGenie_ai.StudyGenie_ai.backend.repository;


import com.StudyGenie_ai.StudyGenie_ai.backend.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
