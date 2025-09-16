package com.example.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.exception.CustomIllegalArgumentException;
import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.models.ETaskStatus;
import com.example.taskmanager.models.Task;
import com.example.taskmanager.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	// fetch all tasks
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// find by ID
	public Task getTaskById(Long ID) {
		return taskRepository.findById(ID)
				.orElseThrow(() -> new ResourceNotFoundException("Task with ID " + ID + " Not Found"));

	}

	// add the task
	public Task addTask(Task task) {
		if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
			throw new CustomIllegalArgumentException("Task title must not be empty");
		} else {
			return taskRepository.save(task);
		}
	}

	// update the task
	public Task updateTask(Long id, Task updatedTask) {
		return taskRepository.findById(id).map(task -> {
			task.setTitle(updatedTask.getTitle());
			task.setDescription(updatedTask.getDescription());
			task.setStatus(updatedTask.getStatus());
			task.setDueDate(updatedTask.getDueDate());
			return taskRepository.save(task);
		}).orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " Not Found"));
	}

	// delete the task
	public void deleteTask(Long id) {
		if (!taskRepository.existsById(id)) {
			throw new ResourceNotFoundException("Task with ID " + id + " Not Found");
		} else {
			taskRepository.deleteById(id);
		}
	}

	// Find by status
	public List<Task> getByStatus(ETaskStatus status) {
		return taskRepository.findByStatus(status);
	}

	public List<Task> search(String keyword) {

		return taskRepository.findByTitleContainingOrDescriptionContaining(keyword, keyword);

	}

//	//Find by duedate before
//	public List<Task> getByDueDate(LocalDateTime date)
//	{
//		return taskRepository.findByDueDateBefore(date);
//	}
}
