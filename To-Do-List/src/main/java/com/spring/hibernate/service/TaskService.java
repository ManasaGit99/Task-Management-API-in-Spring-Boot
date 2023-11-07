package com.spring.hibernate.service;

import java.util.List;

import com.spring.hibernate.entity.Task;

public interface TaskService  {
		List<Task>findAll();
		Task findById(int theId);
		Task save(Task theTask);
		void deleteTask(int theId);
		
}
