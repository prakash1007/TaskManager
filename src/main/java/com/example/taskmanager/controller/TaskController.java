package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.models.ETaskStatus;
import com.example.taskmanager.models.Task;
import com.example.taskmanager.models.User;
import com.example.taskmanager.repository.UserRepo;
import com.example.taskmanager.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserRepo repo;


	@GetMapping(path = "/viewAll", produces = { "application/json" })
	public ResponseEntity<List<Task>> viewAll() {
		List<Task> list = taskService.getAllTasks();
		ResponseEntity<List<Task>> rs = new ResponseEntity<List<Task>>(list, HttpStatus.OK);
		return rs;
	}

	@PostMapping("/addTasks")
	public ResponseEntity<Task> addTask(@RequestBody @Valid Task task) {
		Task savedTask = taskService.addTask(task);
		ResponseEntity<Task> rs = new ResponseEntity<Task>(savedTask, HttpStatus.CREATED);
		return rs;
	}

	@GetMapping
	public String TestRoute() {
		return "Route Reached successfully!";
	}

	@GetMapping("/viewTaskById/{taskId}")
	public ResponseEntity<Task> viewTaskById(@PathVariable("taskId") Long id) {
		Task taskId = taskService.getTaskById(id);
		ResponseEntity<Task> rs = new ResponseEntity<Task>(taskId, HttpStatus.OK);
		return rs;
	}

	@PostMapping("/updateById/{id}")
	public ResponseEntity<Task> updatedTask(@PathVariable Long id, @RequestBody Task task) {
		Task updated = taskService.updateTask(id, task);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.status(HttpStatus.OK).body(("Task with ID " + id + " deleted successfully."));

	}

	@GetMapping("/getByStatus/{status}")
	public ResponseEntity<List<Task>> viewByStatus(@PathVariable ETaskStatus status) {
		List<Task> viewStatusList = taskService.getByStatus(status);
		ResponseEntity<List<Task>> rs = new ResponseEntity<List<Task>>(viewStatusList, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/searchBykeyword/{keyword}")
	public ResponseEntity<List<Task>> searchByKeyword(@PathVariable String keyword) {
		List<Task> searchByKeyword = taskService.search(keyword);
		ResponseEntity<List<Task>> rs = new ResponseEntity<List<Task>>(searchByKeyword, HttpStatus.OK);
		return rs;

	}

//	@GetMapping("csrf-token")
//	public CsrfToken getCsrfToken(HttpServletRequest req)
//	{
//		return (CsrfToken) req.getAttribute("_csrf");
//	}

	@GetMapping("/session-id")
	public String getSessionId(HttpServletRequest request) {
		return "Session ID: " + request.getSession().getId();
	}
	
	@GetMapping("/test-user")
	public ResponseEntity<?> testUser(@RequestParam String username) {
		User user = repo.findByUsername(username);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		return ResponseEntity.ok(user);
	}


}
