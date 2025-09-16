package com.example.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanager.models.ETaskStatus;
import com.example.taskmanager.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByStatus(ETaskStatus status);

	List<Task> findByTitleContainingOrDescriptionContaining(String title, String description);

}
