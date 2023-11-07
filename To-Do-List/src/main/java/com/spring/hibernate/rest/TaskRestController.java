package com.spring.hibernate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.entity.Task;
import com.spring.hibernate.service.TaskService;
@RestController
@RequestMapping("/api")
public class TaskRestController {
		private TaskService taskService;
		
		@Autowired
		public TaskRestController(TaskService taskService) {
			this.taskService = taskService;
		}
		// Get all tasks
		@GetMapping("/tasks")
		public List<Task> findAll(){
			return taskService.findAll();
		}
		
		 // Get a single task by ID
		@GetMapping("/task/{taskId}")
		public Task getTask(@PathVariable int taskId) {
			Task theTask = taskService.findById(taskId);
			
			return theTask;
			
		}
		// Add a new task
		@PostMapping("/tasks")
		public Task addTask(@RequestBody Task theTask) {
			theTask.setId(0);
			Task newTask = taskService.save(theTask);
			return newTask;
		}
		
		// Update an existing task
		@PutMapping("/tasks")
		public Task updateTask(@RequestBody Task theTask) {
			Task tempTask = taskService.save(theTask);
			return tempTask;
		}
		
		// Delete a task by ID
		@DeleteMapping("/tasks/{taskId}")
		public String deleTask(@PathVariable int taskId) {
			Task tempTask = taskService.findById(taskId);
			if(tempTask==null) {
				throw new RuntimeException("Task not Found");
			}
			else {
				taskService.deleteTask(taskId);
			}
			return "Deleted Task Id : " + taskId;
		}
		
		
}
