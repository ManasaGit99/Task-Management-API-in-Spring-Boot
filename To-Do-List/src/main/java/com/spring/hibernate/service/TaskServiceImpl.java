package com.spring.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.entity.Task;
import com.spring.hibernate.repo.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	private TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> findAll() {
		
		return taskRepository.findAll();
	}

	@Override
	public Task findById(int theId) {
		Optional<Task> result = taskRepository.findById(theId);
		Task theTask=null;
		if(result.isPresent()) {
			theTask=result.get();
		}
		else {
			throw new RuntimeException("Task not Found");
		}
		return theTask;
	}

	@Override
	public Task save(Task theTask) {
		
		return taskRepository.save(theTask);
	}

	@Override
	public void deleteTask(int theId) {
		taskRepository.deleteById(theId);
		
	}

}
